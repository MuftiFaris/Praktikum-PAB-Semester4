package com.uns.informatika.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class StudentProfile(
    val fullName: String     = "Mufti Faris Murtadho",
    val nim: String          = "L0124133",
    val faculty: String      = "Fakultas Teknologi Informasi dan Sains Data",
    val studyProgram: String = "Informatika",
    val batch: String        = "2024",
    val university: String   = "Universitas Sebelas Maret",
    val email: String        = "muftifarismurtadho@student.uns.ac.id",
    val github: String       = "github.com/MuftiFaris",
    val linkedin: String     = "linkedin.com/in/mufti-faris"
)

data class ProfileUiState(
    val profile: StudentProfile = StudentProfile(),
    val isEditing: Boolean = false
)

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    fun getShareText(): String {
        val p = _uiState.value.profile
        return """
            Profil Mahasiswa Informatika UNS
            ━━━━━━━━━━━━━━━━━━━━━━━━
            Nama       : ${p.fullName}
            NIM        : ${p.nim}
            Prodi      : ${p.studyProgram} ${p.batch}
            Fakultas   : ${p.faculty}
            Universitas: ${p.university}
            Email      : ${p.email}
        """.trimIndent()
    }
}
