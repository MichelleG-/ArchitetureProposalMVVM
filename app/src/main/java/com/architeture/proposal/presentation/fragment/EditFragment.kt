package com.architeture.proprosal.presentation.fragment

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import com.architeture.proposal.R
import com.architeture.proposal.databinding.FragmentEditBinding
import com.architeture.proprosal.domain.interector.InsertProductInterector
import com.architeture.proprosal.domain.utils.toMoney
import com.architeture.proprosal.presentation.utils.navigate
import com.architeture.proprosal.presentation.view.model.EditFragmentViewModel
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import com.architeture.proprosal.presentation.fragment.EditFragmentDirections
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class EditFragment : BaseFragment<FragmentEditBinding, EditFragmentViewModel>(), OnBackPressedListener {

    @Inject lateinit var insertProduct: InsertProductInterector

    override fun getViewModel(): EditFragmentViewModel = ViewModelProviders.of(this).get(EditFragmentViewModel::class.java)

    override fun getBindingVariable(): Int = BR.editFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_edit

    override fun initBinding() {
        with(binding) {
            val productViewModel = getArgumentProductViewModel()
            setupArguments(productViewModel)
            setupBtnFinish(productViewModel)
        }
    }

    private fun FragmentEditBinding.setupBtnFinish(productViewModel: ProductViewModel) {
        btnFinish.setOnClickListener {
            viewModel.showLoading.set(true)
            insertProduct.execute(
                productViewModel.apply {
                    name = viewModel.productName.value
                    value = viewModel.productValue.value?.toDouble() ?: .0
                    valueFormat = viewModel.productValue.value?.toDouble()?.toMoney()
                }
            ).subscribeBy(
                onError = {
                    viewModel.handleError.set(it)
                    navigate(EditFragmentDirections.actionEditFragmentToMainFragment())
                },
                onComplete = {
                    viewModel.showLoading.set(false)
                    navigate(EditFragmentDirections.actionEditFragmentToMainFragment())
                }
            )
        }
    }

    private fun setupArguments(productViewModel: ProductViewModel) {
        viewModel.setProduct(productViewModel)
    }

    private fun getArgumentProductViewModel(): ProductViewModel {
        return arguments?.let {
            EditFragmentArgs.fromBundle(it).product
        } ?: ProductViewModel(null, null, .0, null)
    }

    override fun onBackPressed() {
        navigate(EditFragmentDirections.actionEditFragmentToMainFragment())
    }
}