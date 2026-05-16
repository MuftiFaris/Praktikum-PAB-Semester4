package com.uns.informatika.data.repository

import com.uns.informatika.R
import com.uns.informatika.data.model.Category
import com.uns.informatika.data.model.InfoItem
import com.uns.informatika.data.model.MetaInfo

object InfoRepository {

    val allItems: List<InfoItem> = listOf(
        // ── DOSEN (5) ─────────────────────────────────────────────────────
        InfoItem(
            id = 1,
            title = "Prof. Dr. Bambang Harjito",
            shortDesc = "Kepala Jurusan, spesialis AI & ML",
            fullDesc = "Prof. Bambang Harjito adalah Kepala Jurusan Informatika UNS dengan spesialisasi di bidang Kecerdasan Buatan.",
            category = Category.DOSEN,
            imageRes = R.drawable.ic_dosen,
            meta = listOf(MetaInfo("Bidang", "AI & ML"), MetaInfo("Exp", "20 Thn"), MetaInfo("Pub", "50+"))
        ),
        InfoItem(
            id = 2,
            title = "Dr. Fitria Wulandari, M.Kom.",
            shortDesc = "Dosen Pemrograman Web & RPL",
            fullDesc = "Dr. Fitria Wulandari merupakan dosen pengampu mata kuliah Pemrograman Web dan Rekayasa Perangkat Lunak.",
            category = Category.DOSEN,
            imageRes = R.drawable.ic_dosen,
            meta = listOf(MetaInfo("Bidang", "Web & RPL"), MetaInfo("Exp", "12 Thn"), MetaInfo("Pub", "28+"))
        ),
        InfoItem(
            id = 7,
            title = "Drs. Sahirul Alim, M.Sc.",
            shortDesc = "Dosen Basis Data & Sistem Informasi",
            fullDesc = "Ahli dalam manajemen basis data relasional dan pengembangan sistem informasi enterprise.",
            category = Category.DOSEN,
            imageRes = R.drawable.ic_dosen,
            meta = listOf(MetaInfo("Bidang", "Database"), MetaInfo("Exp", "15 Thn"), MetaInfo("Pub", "20+"))
        ),
        InfoItem(
            id = 8,
            title = "Aris Tri Jaka L., S.Kom, M.Kom",
            shortDesc = "Dosen Jaringan & Keamanan Siber",
            fullDesc = "Fokus pada infrastruktur jaringan, keamanan sistem, dan administrasi server Linux.",
            category = Category.DOSEN,
            imageRes = R.drawable.ic_dosen,
            meta = listOf(MetaInfo("Bidang", "Network"), MetaInfo("Exp", "10 Thn"), MetaInfo("Pub", "15+"))
        ),
        InfoItem(
            id = 9,
            title = "Winarno, S.Si, M.Eng",
            shortDesc = "Dosen Grafika Komputer & Visi Mesin",
            fullDesc = "Mengajar grafika komputer, pengolahan citra digital, dan visi komputer untuk robotika.",
            category = Category.DOSEN,
            imageRes = R.drawable.ic_dosen,
            meta = listOf(MetaInfo("Bidang", "Vision"), MetaInfo("Exp", "14 Thn"), MetaInfo("Pub", "22+"))
        ),

        // ── MATA KULIAH (10) ──────────────────────────────────────────────
        InfoItem(
            id = 3,
            title = "Algoritma & Pemrograman",
            shortDesc = "Dasar pemrograman dengan C++",
            fullDesc = "Konsep dasar logika pemrograman, struktur kontrol, dan algoritma fundamental.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "1"), MetaInfo("Lab", "Ya"))
        ),
        InfoItem(
            id = 4,
            title = "Pemrograman Mobile",
            shortDesc = "Android dengan Kotlin & Compose",
            fullDesc = "Pengembangan aplikasi Android modern menggunakan Jetpack Compose dan MVVM.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "5"), MetaInfo("Lab", "Ya"))
        ),
        InfoItem(
            id = 10,
            title = "Sistem Basis Data",
            shortDesc = "Manajemen data SQL & NoSQL",
            fullDesc = "Perancangan database, normalisasi, dan query kompleks menggunakan MySQL/PostgreSQL.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "2"), MetaInfo("Lab", "Ya"))
        ),
        InfoItem(
            id = 11,
            title = "Jaringan Komputer",
            shortDesc = "Konsep TCP/IP dan Routing",
            fullDesc = "Mempelajari lapisan OSI, protokol internet, subnetting, dan administrasi jaringan.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "3"), MetaInfo("Lab", "Ya"))
        ),
        InfoItem(
            id = 12,
            title = "Kecerdasan Buatan",
            shortDesc = "Pengantar AI dan Machine Learning",
            fullDesc = "Algoritma pencarian, logika fuzzy, neural networks, dan implementasi AI dasar.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "4"), MetaInfo("Lab", "Tidak"))
        ),
        InfoItem(
            id = 13,
            title = "Sistem Operasi",
            shortDesc = "Manajemen proses dan memori",
            fullDesc = "Cara kerja OS, kernel, scheduling, concurrency, dan sistem berkas.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "3"), MetaInfo("Lab", "Tidak"))
        ),
        InfoItem(
            id = 14,
            title = "Interaksi Manusia & Komputer",
            shortDesc = "Desain UI/UX dan Prototyping",
            fullDesc = "Prinsip desain antarmuka, user experience, dan pembuatan prototipe aplikasi.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "2"), MetaInfo("Sem", "4"), MetaInfo("Lab", "Tidak"))
        ),
        InfoItem(
            id = 15,
            title = "Keamanan Informasi",
            shortDesc = "Kriptografi dan Keamanan Siber",
            fullDesc = "Teknik enkripsi, keamanan jaringan, dan perlindungan data dari serangan siber.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "6"), MetaInfo("Lab", "Ya"))
        ),
        InfoItem(
            id = 16,
            title = "Pemrograman Web",
            shortDesc = "Fullstack Web Development",
            fullDesc = "Membangun aplikasi web menggunakan HTML, CSS, JS, dan framework backend.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "4"), MetaInfo("Lab", "Ya"))
        ),
        InfoItem(
            id = 17,
            title = "Analisis & Desain Sistem",
            shortDesc = "Pemodelan UML dan SDLC",
            fullDesc = "Metodologi pengembangan perangkat lunak dan teknik pemodelan sistem bisnis.",
            category = Category.MATA_KULIAH,
            imageRes = R.drawable.ic_matakuliah,
            meta = listOf(MetaInfo("SKS", "3"), MetaInfo("Sem", "5"), MetaInfo("Lab", "Tidak"))
        ),

        // ── LABORATORIUM & FASILITAS ──────────────────────────────────────
        InfoItem(
            id = 5,
            title = "Laboratorium Komputer A",
            shortDesc = "Lab utama 50 workstation",
            fullDesc = "Fasilitas utama praktikum dengan spesifikasi PC tinggi untuk mendukung pemrograman.",
            category = Category.LABORATORIUM,
            imageRes = R.drawable.ic_lab,
            meta = listOf(MetaInfo("Kapasitas", "50"), MetaInfo("Lokasi", "Gedung B"), MetaInfo("Jam", "07-20"))
        ),
        InfoItem(
            id = 6,
            title = "Student Lounge",
            shortDesc = "Ruang diskusi & Wi-Fi cepat",
            fullDesc = "Tempat favorit mahasiswa untuk mengerjakan tugas dan diskusi kelompok.",
            category = Category.FASILITAS,
            imageRes = R.drawable.ic_fasilitas,
            meta = listOf(MetaInfo("Kapasitas", "60"), MetaInfo("Lokasi", "Gedung B"), MetaInfo("Status", "Aktif"))
        )
    )

    fun getById(id: Int): InfoItem? = allItems.find { it.id == id }

    fun getByCategory(category: Category): List<InfoItem> =
        allItems.filter { it.category == category }

    fun search(query: String): List<InfoItem> {
        val q = query.lowercase()
        return allItems.filter {
            it.title.lowercase().contains(q) ||
            it.shortDesc.lowercase().contains(q) ||
            it.category.displayName.lowercase().contains(q)
        }
    }
}
