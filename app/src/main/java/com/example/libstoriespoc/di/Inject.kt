package com.example.libstoriespoc.di

object Inject {

    val appModule = module {

        single { CounterRespository(get()) }

        factory { CreateCounter(get()) }

        factory { Update(get()) }

        factory { DeleteCounters(get()) }

        factory { GetCounters(get()) }

        viewModel<CounterViewModel> { CounterViewModelImp(get(),get(),get(),get()) }



    }

}