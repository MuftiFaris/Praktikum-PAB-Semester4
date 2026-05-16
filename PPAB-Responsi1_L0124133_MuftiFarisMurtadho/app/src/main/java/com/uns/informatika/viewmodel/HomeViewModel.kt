package com.uns.informatika.viewmodel

import androidx.lifecycle.ViewModel
import com.uns.informatika.data.model.Category
import com.uns.informatika.data.model.InfoItem
import com.uns.informatika.data.repository.InfoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomeUiState(
    val dosenCount: Int = 0,
    val mataKuliahCount: Int = 0,
    val labCount: Int = 0,
    val fasilitasCount: Int = 0,
    val featuredItems: List<InfoItem> = emptyList()
)

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomeData()
    }

    private fun loadHomeData() {
        val all = InfoRepository.allItems
        _uiState.value = HomeUiState(
            dosenCount       = all.count { it.category == Category.DOSEN },
            mataKuliahCount  = all.count { it.category == Category.MATA_KULIAH },
            labCount         = all.count { it.category == Category.LABORATORIUM },
            fasilitasCount   = all.count { it.category == Category.FASILITAS },
            featuredItems    = all.take(3)
        )
    }
}
