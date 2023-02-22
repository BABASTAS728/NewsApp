package com.example.newsapp.ui.utils

import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object ProgressBarBinding {
    @JvmStatic
    @BindingAdapter ("goneUnless")
    fun ProgressBar.setVisibility(visibility: Boolean?){
        if (visibility!=null){
            this.isVisible = visibility
        }
    }
}