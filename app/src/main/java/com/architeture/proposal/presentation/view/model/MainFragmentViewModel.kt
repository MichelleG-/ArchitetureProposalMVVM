package com.architeture.proprosal.presentation.view.model

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import com.architeture.proprosal.domain.interector.GetAllProductsByIdInterector
import com.architeture.proprosal.presentation.view.BaseViewModel
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    getAllProductsByIdInterector: GetAllProductsByIdInterector
) : BaseViewModel() {

    val products: LiveData<List<ProductViewModel>> = getAllProductsByIdInterector.execute(Unit)
}