package com.uns.informatika.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uns.informatika.R
import com.uns.informatika.ui.components.FeatureCard
import com.uns.informatika.ui.components.InfoHighlightCard
import com.uns.informatika.ui.components.SectionTitle
import com.uns.informatika.ui.theme.Amber50
import com.uns.informatika.ui.theme.Amber700
import com.uns.informatika.ui.theme.Blue50
import com.uns.informatika.ui.theme.Blue800
import com.uns.informatika.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateToList: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_uns),
                            contentDescription = null,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Informatika UNS",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = "Info",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // ── Hero Banner ───────────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.linearGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                Color(0xFF0D47A1)
                            )
                        )
                    )
                    .padding(horizontal = 20.dp, vertical = 24.dp)
            ) {
                Column {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = Color.White.copy(alpha = 0.15f)
                    ) {
                        Text(
                            text = "Universitas Sebelas Maret",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            color = Color.White,
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Fakultas Informatika\nExplorer App",
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Temukan informasi lengkap tentang dosen, mata kuliah, laboratorium, dan fasilitas Jurusan Informatika UNS.",
                        color = Color.White.copy(alpha = 0.85f),
                        style = MaterialTheme.typography.bodySmall,
                        lineHeight = 18.sp
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = onNavigateToList,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = MaterialTheme.colorScheme.primary
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Jelajahi Sekarang",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // ── Stats Strip ───────────────────────────────────────────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(count = uiState.dosenCount, label = "Dosen")
                VerticalDivider(modifier = Modifier.height(32.dp))
                StatItem(count = uiState.mataKuliahCount, label = "Matkul")
                VerticalDivider(modifier = Modifier.height(32.dp))
                StatItem(count = uiState.labCount, label = "Lab")
                VerticalDivider(modifier = Modifier.height(32.dp))
                StatItem(count = uiState.fasilitasCount, label = "Fasilitas")
            }

            // ── Quick Access ──────────────────────────────────────────────────
            SectionTitle(text = "Jelajahi Kategori")
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    FeatureCard("👨‍🏫", "Dosen", Blue50, Blue800, onClick = onNavigateToList)
                }
                item {
                    FeatureCard("📚", "Matkul", Amber50, Amber700, onClick = onNavigateToList)
                }
                item {
                    FeatureCard("🔬", "Lab", Color(0xFFE0F2F1), Color(0xFF00695C), onClick = onNavigateToList)
                }
                item {
                    FeatureCard("🏛️", "Fasilitas", Color(0xFFFFEBEE), Color(0xFFC62828), onClick = onNavigateToList)
                }
            }

            // ── Welcome Note ──────────────────────────────────────────────────
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                ),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = "👋", fontSize = 28.sp)
                    Column {
                        Text(
                            text = "Selamat Datang!",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                        Text(
                            text = "Jelajahi informasi lengkap Jurusan Informatika UNS di sini.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.8f),
                            lineHeight = 18.sp
                        )
                    }
                }
            }

            // ── Info Cards ────────────────────────────────────────────────────
            SectionTitle(text = "Tentang Jurusan")

            InfoHighlightCard(
                icon = Icons.Outlined.Info,
                title = "Informatika UNS",
                body = "Program Studi Informatika Universitas Sebelas Maret (UNS) Surakarta didirikan pada tahun 1994. Terakreditasi A oleh BAN-PT.",
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            InfoHighlightCard(
                icon = Icons.Outlined.Star,
                title = "Prestasi",
                body = "Juara 1 National Programming Contest 2023. Peringkat 5 ICPC Asia Regional.",
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
private fun StatItem(count: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = count.toString(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}
