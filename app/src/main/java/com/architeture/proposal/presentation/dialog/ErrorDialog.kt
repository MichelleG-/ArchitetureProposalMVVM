package com.architeture.proprosal.presentation.dialog

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.architeture.proposal.R
import com.architeture.proposal.databinding.DialogErrorBinding

import com.architeture.proprosal.presentation.view.model.ErrorViewModel

class ErrorDialog : BaseDialog<DialogErrorBinding, ErrorViewModel>() {

    companion object {
        private const val TAG = "error_loading"

        @Synchronized
        fun newInstance(): ErrorDialog = ErrorDialog()
    }

    override fun getBindingVariable(): Int = BR.errorViewModel

    override fun getLayoutId(): Int = R.layout.dialog_error

    override fun getViewModel(): ErrorViewModel = ViewModelProviders.of(this).get(ErrorViewModel::class.java)

    override fun initBinding() {
        viewModel.observableInt.observe(this, Observer<Int> {text ->
            binding.tvMessageError.text = resources.getText(text)
        })
    }

    override fun getDialogTag(): String = TAG

    fun handleThrowable(throwable: Throwable?) {
        throwable?.let {
            viewModel.handleThrowable(it)
        }
    }

}