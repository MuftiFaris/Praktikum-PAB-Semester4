# Informatics Faculty Explorer — Android App

Aplikasi Android untuk menjelajahi informasi Jurusan Informatika UNS.
Dibangun dengan **Kotlin + Jetpack Compose + Material 3**.

---

## Fitur Utama

| Fitur | Detail |
|---|---|
| Bottom Navigation | Home, Daftar, Profil |
| Home Screen | Banner, stats, kategori, info jurusan |
| List Screen | LazyColumn, 12 item, search bar, filter tab kategori |
| Detail Screen | Gambar besar, deskripsi lengkap, meta info, tombol favorit |
| Profile Screen | Data mahasiswa, avatar inisial, share intent |
| Share Feature | Intent.ACTION_SEND membagikan profil ke app lain |

---

## Tech Stack

- **Kotlin** 2.x
- **Jetpack Compose** (BOM 2024.x)
- **Material 3** (Material You)
- **Navigation Compose** 2.8.x
- **ViewModel + StateFlow**
- **Kotlin Coroutines**

---

## Struktur Proyek

```
app/src/main/java/com/uns/informatika/
│
├── data/
│   ├── model/
│   │   └── InfoItem.kt          # Data class: InfoItem, MetaInfo, Category enum
│   └── repository/
│       └── InfoRepository.kt    # 12 dummy items + query helpers
│
├── ui/
│   ├── screens/
│   │   ├── home/
│   │   │   └── HomeScreen.kt    # Banner, stats strip, feature cards, info cards
│   │   ├── list/
│   │   │   └── ListScreen.kt    # LazyColumn + search + FilterChip tabs
│   │   ├── detail/
│   │   │   └── DetailScreen.kt  # Hero image, meta card, full description, favorite
│   │   └── profile/
│   │       └── ProfileScreen.kt # Avatar, data rows, share button
│   │
│   ├── components/
│   │   └── Components.kt        # CategoryBadge, InfoItemCard, FeatureCard,
│   │                            #   InfoHighlightCard, MetaInfoRow, ProfileInfoRow
│   └── theme/
│       ├── Theme.kt             # Light + Dark color schemes
│       └── Typography.kt        # Full Material3 typography scale
│
├── navigation/
│   └── Navigation.kt            # Screen sealed class, BottomNavItem, NavGraph
│
├── viewmodel/
│   ├── HomeViewModel.kt         # HomeUiState + category counts
│   ├── ListViewModel.kt         # ListUiState + search + category filter
│   ├── DetailViewModel.kt       # DetailUiState + favorite toggle
│   └── ProfileViewModel.kt      # StudentProfile + getShareText()
│
└── MainActivity.kt              # ComponentActivity, Scaffold, BottomNavBar
```

---

## Setup di Android Studio

1. **Clone / buka project** di Android Studio Ladybug (2024.2+) atau lebih baru.
2. Pastikan **Gradle** sync berhasil.
3. Jalankan di **emulator** (API 24+) atau device fisik.
4. Untuk gambar nyata, uncomment dependensi Coil di `build.gradle.kts`
   dan ganti `Box + Text(emoji)` dengan `AsyncImage`.

---

## Poin Nilai (sesuai assignment)

- [x] **UI Components** — Card, Button, Text, Icon, Scaffold, TopAppBar, dll.
- [x] **Layouting & Styling** — Row, Column, Box, padding, elevation, RoundedCorner
- [x] **LazyColumn** — ListScreen dengan 12+ item, key berbeda tiap item
- [x] **State** — `remember`, `mutableStateOf`, `StateFlow`, `collectAsState`
- [x] **Navigation** — NavHost, composable(), argumen itemId, back stack
- [x] **ViewModel** — HomeVM, ListVM, DetailVM, ProfileVM, StateFlow pattern
- [x] **Bottom Navigation** — NavigationBar + NavigationBarItem
- [x] **Share Feature** — `Intent.ACTION_SEND` di ProfileScreen
- [x] **Min 10 item** — 12 item (4 dosen, 4 MK, 3 lab, 1 fasilitas)
- [x] **Detail Screen** — gambar besar + judul + deskripsi lengkap
- [x] **Profil** — foto (avatar), nama, NIM, prodi, angkatan, fakultas, univ, email
