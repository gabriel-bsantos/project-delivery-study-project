package com.composetest.advicesapp.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composetest.advicesapp.domain.repository.AdviceRepository
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val adviceRepository: AdviceRepository
): ViewModel() {

    private val _adviceText = MutableStateFlow<String?>(null)
    val adviceText = _adviceText.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    init {
        getAdviceText()
    }

    fun getAdviceText() {
        viewModelScope.launch (Dispatchers.IO) {
            _isLoading.value = true
            adviceRepository.getRandomAdvice().let { response ->
                when(response){
                    is NetworkResponse.Success -> _adviceText.value = response.body
                    else -> {}
                }
            }
            _isLoading.value = false
        }
    }
}