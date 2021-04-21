package com.example.dmsapp.ui


import com.example.dmsapp.intent.Intent
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dmsapp.repository.AutoRepository
import com.example.dmsapp.utils.DataState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject constructor(
    private val autoRepository: AutoRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel(){
    val userIntent = Channel<Intent>(Channel.UNLIMITED)
    private val _dataState= MutableStateFlow<DataState>(DataState.Idle)

    val dataState: StateFlow<DataState>
        get() = _dataState
    init {
        setStateEvent()
    }
    fun setStateEvent(){
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect{intn ->
                when(intn){
                    is Intent.GetAutoEvent -> {
                        autoRepository.getAuto()
                            .onEach {
                                _dataState.value = it
                            }
                            .launchIn(viewModelScope)
                    }
                    Intent.None -> {

                    }
                }

            }
        }
    }
}