package com.architeture.proprosal.presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.architeture.proprosal.presentation.BaseObserver
import com.architeture.proprosal.presentation.activity.BaseActivity
import com.architeture.proprosal.presentation.utils.inject
import com.architeture.proprosal.presentation.view.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseDialog<T : ViewDataBinding, V : BaseViewModel> : DialogFragment(), HasSupportFragmentInjector {

    private lateinit var baseActivity: BaseActivity<T, V>
    private lateinit var baseObserver: BaseObserver

    internal lateinit var binding: T
    internal lateinit var viewModel: V

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun initBinding()

    abstract fun getDialogTag(): String

    fun getBaseActivity(): BaseActivity<T, V> = baseActivity

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

        initBinding()
    }

    fun show(fragmentManager: FragmentManager) {
        show(fragmentManager, getDialogTag())
    }
}