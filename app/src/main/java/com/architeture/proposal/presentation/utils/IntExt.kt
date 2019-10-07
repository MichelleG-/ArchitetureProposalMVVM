package com.architeture.proprosal.presentation.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View

fun Int.inflate(context: Context): View =
        LayoutInflater.from(context).inflate(this, null, false)