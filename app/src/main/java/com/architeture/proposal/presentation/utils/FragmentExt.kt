package com.architeture.proprosal.presentation.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import dagger.android.support.AndroidSupportInjection

fun Fragment.inject() {
    AndroidSupportInjection.inject(this)
}

fun Fragment.navigate(action: Int) = NavHostFragment.findNavController(this).navigate(action)

fun Fragment.navigate(action: NavDirections) = NavHostFragment.findNavController(this).navigate(action)

fun Fragment.navigate(action: Int, args: Bundle) = NavHostFragment.findNavController(this).navigate(action, args)

fun Fragment.popBackStack() = NavHostFragment.findNavController(this).popBackStack()

fun Fragment.popBackStack(local: Int, inclusive: Boolean = false) = NavHostFragment.findNavController(this).popBackStack(local, inclusive)