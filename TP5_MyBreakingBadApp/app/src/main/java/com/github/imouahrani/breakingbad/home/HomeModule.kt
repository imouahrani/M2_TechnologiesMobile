package com.github.imouahrani.breakingbad.home

import com.github.imouahrani.breakingbad.data.CharacterApiService
import com.github.imouahrani.breakingbad.data.CharacterInteractor
import com.github.imouahrani.breakingbad.navigation.Navigator
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule: Module = module {

    factory<CharacterApiService> {
        get<Retrofit>().create(CharacterApiService::class.java)
    }

    factory {
        CharacterInteractor(apiService = get())
    }

    viewModel {
        HomeViewModel(
            dispatchers = get(),
            characterInteractor = get(),
            navigator = Navigator(),
            lastSeason = 5
        )
    }

}