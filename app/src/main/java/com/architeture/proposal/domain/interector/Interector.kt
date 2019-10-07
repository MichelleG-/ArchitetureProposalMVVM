package com.architeture.proprosal.domain.interector

interface Interector<in PARAM, out RESPONSE> {
    fun execute(param: PARAM): RESPONSE
}