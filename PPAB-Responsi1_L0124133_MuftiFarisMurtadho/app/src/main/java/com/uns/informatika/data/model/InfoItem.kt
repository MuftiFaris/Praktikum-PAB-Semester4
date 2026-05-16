package com.uns.informatika.data.model

data class InfoItem(
    val id: Int,
    val title: String,
    val shortDesc: String,
    val fullDesc: String,
    val category: Category,
    val imageRes: Int,
    val meta: List<MetaInfo> = emptyList()
)

data class MetaInfo(
    val label: String,
    val value: String
)

enum class Category(val displayName: String) {
    DOSEN("Dosen"),
    MATA_KULIAH("Mata Kuliah"),
    LABORATORIUM("Laboratorium"),
    FASILITAS("Fasilitas")
}
