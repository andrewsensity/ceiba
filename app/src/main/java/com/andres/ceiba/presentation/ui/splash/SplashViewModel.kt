package com.andres.ceiba.presentation.ui.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import com.andres.ceiba.presentation.viewmodels.CeibaViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {
/*
    private var job: Job = Job()
    var species by mutableStateOf(SpeciesInDTO())
        private set
    var location = mutableStateListOf<LocationInDTO>()
        private set

    init {
        insertAllPokemon()
        insertEvolution()
    }

    private fun insertAllPokemon() {
        viewModelScope.launch {
            useCases.getAllPokemonUseCase(PAGE_SIZE, LIMIT)
                .onSuccess { pokemonListInDTO ->
                    useCases.insertPokemonListUseCase(pokemonListInDTO.results)
                    insertPokemon(pokemonListInDTO.results)
                }.onFailure {
                    return@onFailure
                }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun insertPokemon(list: List<Results>) {
        cancelJobIfRunning()
        job = GlobalScope.launch {
            list.forEach { results ->
                val id = results.url.getIdFromUrl()
                val pokemonInDTO = useCases.getPokemonUseCase(id).getOrDefault(PokemonInDTO())
                useCases.insertPokemonUseCase(pokemonInDTO)
            }
        }
    }

    private fun insertEvolution() {
        viewModelScope.launch {
            for (i in 0..78) {
                useCases.getPokemonEvolutionUseCase(i)
                    .onSuccess { evolutionsInDto ->
                        useCases.insertEvolutionsLocalUseCase(evolutionsInDto)
                    }.onFailure {
                        return@onFailure
                    }
            }
        }
    }

    private fun cancelJobIfRunning() {
        if (job.isActive) {
            job.cancel()
        }
    }*/
}