package com.architeture.proprosal.presentation.view.model

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.architeture.proprosal.domain.utils.toMoney
import com.architeture.proprosal.presentation.view.BaseViewModel
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel

class EditFragmentViewModel : BaseViewModel() {

    val productName = MutableLiveData<String>()

    val productValue = MutableLiveData<String>()

    fun setProduct(productViewModel: ProductViewModel) {
        productName.value = productViewModel.name
        productValue.value = productViewModel.value.toString()
    }
}