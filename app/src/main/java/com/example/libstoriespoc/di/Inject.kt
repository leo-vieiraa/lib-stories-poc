package com.example.libstoriespoc.di

import com.example.libstoriespoc.data.repository.StoriesRepository
import com.example.libstoriespoc.presentation.viewmodel.StoriesViewModel
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.dsl.module

object Inject {

    val appModule = module {

        factory { StoriesRepository(get()) }

        viewModel { StoriesViewModel(get()) }

    }
}