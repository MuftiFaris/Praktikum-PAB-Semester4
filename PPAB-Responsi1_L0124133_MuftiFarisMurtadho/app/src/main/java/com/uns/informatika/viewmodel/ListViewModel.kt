package com.uns.informatika.viewmodel

import androidx.lifecycle.ViewModel
import com.uns.informatika.data.model.Category
import com.uns.informatika.data.model.InfoItem
import com.uns.informatika.data.repository.InfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ListUiState(
    val items: List<InfoItem> = emptyList(),
    val searchQuery: String = "",
    val selectedCategory: Category? = null,
    val isLoading: Boolean = false
)

class ListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ListUiState())
    val uiState: StateFlow<ListUiState> = _uiState.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        _uiState.update { it.copy(isLoading = true) }
        val all = InfoRepository.allItems
        _uiState.update { it.copy(items = all, isLoading = false) }
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
        applyFilters()
    }

    fun onCategorySelected(category: Category?) {
        _uiState.update { it.copy(selectedCategory = category) }
        applyFilters()
    }

    private fun applyFilters() {
        val state = _uiState.value
        val all = InfoRepository.allItems
        val filtered = all.filter { item ->
            val matchesSearch = state.searchQuery.isBlank() ||
                item.title.contains(state.searchQuery, ignoreCase = true) ||
                item.shortDesc.contains(state.searchQuery, ignoreCase = true)
            val matchesCategory = state.selectedCategory == null ||
                item.category == state.selectedCategory
            matchesSearch && matchesCategory
        }
        _uiState.update { it.copy(items = filtered) }
    }

    fun clearSearch() {
        _uiState.update { it.copy(searchQuery = "") }
        applyFilters()
    }
}
