package com.architeture.proprosal.presentation.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.Navigation.findNavController

fun View.inflate(idLayout: Int) =
        LayoutInflater.from(context).inflate(idLayout, null, false)

fun View.navigate(action: Int) = findNavController(this).navigate(action)

fun View.navigate(action: Int, args: Bundle) = findNavController(this).navigate(action, args)

fun View.popBackStack() = findNavController(this).popBackStack()