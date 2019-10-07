package com.architeture.proprosal.domain.mapper

interface Mapper <VIEWMODEL, MODEL> {
    fun mapperToPresentation(response: MODEL) : VIEWMODEL
    fun mapperToInfra(param: VIEWMODEL): MODEL
}