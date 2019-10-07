package com.architeture.proprosal.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.architeture.proprosal.presentation.BaseObserver
import com.architeture.proprosal.presentation.activity.BaseActivity
import com.architeture.proprosal.presentation.utils.inject
import com.architeture.proprosal.presentation.view.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment(), HasSupportFragmentInjector {

    private lateinit var baseActivity: BaseActivity<T, V>
    private lateinit var baseObserver: BaseObserver

    internal lateinit var binding: T
    internal lateinit var viewModel: V

    abstract fun getViewModel(): V

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initBinding()

    fun getBaseActivity(): BaseActivity<T, V> = baseActivity

    @Inject lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = childFragmentInjector

    override fun onAttach(context: Context) {
        inject()
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()

        baseObserver = BaseObserver(viewModel.showLoading, viewModel.handleError, fragmentManager)
        baseObserver.observeChanges()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

        initBinding()
    }
}

interface OnBackPressedListener {
    fun onBackPressed()
}