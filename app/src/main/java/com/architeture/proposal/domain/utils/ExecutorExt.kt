package com.architeture.proprosal.domain.utils

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

val observerOn: Scheduler = AndroidSchedulers.mainThread()
val subscribeOn = Schedulers.io()

fun Completable.withExecutor() =
    this.observeOn(observerOn)
        .subscribeOn(subscribeOn)

fun Single<Any>.withExecutor() =
    this.observeOn(observerOn)
        .subscribeOn(subscribeOn)