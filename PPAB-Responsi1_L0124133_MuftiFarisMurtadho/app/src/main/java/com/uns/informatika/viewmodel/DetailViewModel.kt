package com.uns.informatika.viewmodel

import androidx.lifecycle.ViewModel
import com.uns.informatika.data.model.InfoItem
import com.uns.informatika.data.repository.InfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DetailUiState(
    val item: InfoItem? = null,
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false
)

class DetailViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadItem(id: Int) {
        _uiState.update { it.copy(isLoading = true) }
        val item = InfoRepository.getById(id)
        _uiState.update { it.copy(item = item, isLoading = false) }
    }

    fun toggleFavorite() {
        _uiState.update { it.copy(isFavorite = !it.isFavorite) }
    }
}
