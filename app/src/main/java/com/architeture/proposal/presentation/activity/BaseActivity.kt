package com.architeture.proprosal.presentation.activity

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.architeture.proprosal.presentation.BaseObserver
import com.architeture.proprosal.presentation.fragment.OnBackPressedListener
import com.architeture.proprosal.presentation.utils.inject
import com.architeture.proprosal.presentation.view.BaseViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

typealias RequestPermissionListener = (granted: Boolean) -> Unit

abstract class BaseActivity<T: ViewDataBinding, V: BaseViewModel> : AppCompatActivity(), HasSupportFragmentInjector {

    private val permissionsRequestCode = 0
    private lateinit var requestPermissionListener: RequestPermissionListener
    private lateinit var baseObserver: BaseObserver

    internal lateinit var binding: T
    internal lateinit var viewModel: V

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentDispatchingAndroidInjector

    abstract fun getBindingVariable(): Int

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    abstract fun initBinding()

    @IdRes
    abstract fun getNavContainer(): Int

    abstract fun getNavContainerFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)

        viewModel = getViewModel()

        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.setVariable(getBindingVariable(), viewModel)
        binding.executePendingBindings()

        baseObserver = BaseObserver(viewModel.showLoading, viewModel.handleError, supportFragmentManager)
        baseObserver.observeChanges()

        initBinding()
    }

    fun requestPermission(
        permission: String,
        requestPermissionListener: RequestPermissionListener
    ) {
        this.requestPermissionListener = requestPermissionListener
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            requestPermissionListener(true)
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(permission),
                permissionsRequestCode
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            permissionsRequestCode -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestPermissionListener(true)
                } else {
                    requestPermissionListener(false)
                }
            }
        }
    }

    override fun onBackPressed() {
        val currentFragment = getNavContainerFragment().childFragmentManager.fragments[0]
        val controller = Navigation.findNavController(this, getNavContainer())
        if (currentFragment is OnBackPressedListener)
            currentFragment.onBackPressed()
        else if (!controller.popBackStack())
            super.onBackPressed()
    }

}