package com.architeture.proprosal.presentation.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.architeture.proposal.R
import com.architeture.proprosal.presentation.utils.inflate

class LoadingDialog : DialogFragment() {

    companion object {
        private const val TAG = "dialog_loading"

        @Synchronized
        fun newInstance(): LoadingDialog {
            return LoadingDialog()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return context?.let {
            AlertDialog.Builder(it)
                .setView(R.layout.dialog_loading.inflate(it))
                .create()
        } ?: run {
            super.onCreateDialog(savedInstanceState)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun show(fragmentManager: FragmentManager) {
        show(fragmentManager, TAG)
    }

}