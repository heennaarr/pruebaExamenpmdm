package com.example.pmdmsimul.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pmdmsimul.domain.GetItemSelectedUseCase
import com.example.pmdmsimul.domain.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ItemDetailViewModel(private val getItemSelectedUseCase: GetItemSelectedUseCase): ViewModel() {
    private var _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _uiState

    fun loadItems(id:String){
        _uiState.value = UiState(isLoading = true)

        viewModelScope.launch (Dispatchers.IO){
            _uiState.postValue(UiState(item =getItemSelectedUseCase.invoke(id)))

        }
    }
    data class UiState(
        val isLoading:Boolean = false,
        val errorApp: Throwable? = null,
        val item: Item? = null

    )
}