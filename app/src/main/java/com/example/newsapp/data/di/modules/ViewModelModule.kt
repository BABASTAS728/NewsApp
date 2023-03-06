package com.example.newsapp.data.di.modules

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.di.ViewModelKey
import com.example.newsapp.ui.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    fun bindNewsViewModel(viewModel: NewsViewModel): ViewModel
}