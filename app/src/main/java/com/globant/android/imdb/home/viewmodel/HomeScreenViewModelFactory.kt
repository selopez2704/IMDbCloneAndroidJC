package com.globant.android.imdb.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.globant.android.imdb.repository.MoviesRepository


@Suppress("UNCHECKED CAST")
class HomeScreenViewModelFactory(private val repository:MoviesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass:Class<T>):T {
        return HomeScreenViewModel(repository) as T
    }
}

//private val viewModel: HomeScreenViewModel by viewModels { HomeScreenViewModelFactory(ARGUMENTS) }