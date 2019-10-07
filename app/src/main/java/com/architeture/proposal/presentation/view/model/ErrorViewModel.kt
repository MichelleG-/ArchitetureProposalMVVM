package com.architeture.proprosal.presentation.view.model

import androidx.lifecycle.MutableLiveData
import com.architeture.proposal.R
import com.architeture.proprosal.presentation.view.BaseViewModel

class ErrorViewModel : BaseViewModel() {

    val observableInt = MutableLiveData<Int>()

    fun handleThrowable(throwable: Throwable) {
        observableInt.value = R.string.error_unespliqued
    }

}