package com.example.pmdmsimul.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdmsimul.domain.GetItemsUseCase
import com.example.pmdmsimul.domain.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ItemViewModel(
    private val getItemsUseCase: GetItemsUseCase
): ViewModel() {
    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadItems(){
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch (Dispatchers.IO){
            _uiState.postValue(UiState(items = getItemsUseCase.invoke()))

        }
    }
    data class UiState(
        val isLoading:Boolean = false,
        val errorApp: Throwable? = null,
        val items : List<Item>? = null

    )
}
