package com.tugas2.ppab_02_l0124133_muftifarismurtadho

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugas2.ppab_02_l0124133_muftifarismurtadho.ui.theme.PPAB02_L0124133_MuftiFarisMurtadhoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PPAB02_L0124133_MuftiFarisMurtadhoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    StudentProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StudentProfileScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val name = "Mufti Faris Murtadho"
    val nim = "L0124133"
    val major = "Informatika, 2024"

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- Bagian Foto Profil (Polos/Kosong) ---
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .size(130.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Foto Profil Kosong",
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.outline
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Info Nama & NIM ---
        Text(
            text = name,
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Text(
            text = "NIM: $nim",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = major,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.outline,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // --- Card Deskripsi ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Tentang Saya",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Seorang mahasiswa yang antusias dalam mempelajari pengembangan aplikasi Android. Senang bereksperimen dengan UI yang modern dan fungsional menggunakan Jetpack Compose.",
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- Tombol-Tombol Aksi (Kreatif & Beragam) ---
        
        // 1. ACTION_SEND: Share Text
        IntentButton(
            label = "Bagikan Profil",
            description = "ACTION_SEND",
            icon = Icons.AutoMirrored.Filled.Send,
            onClick = {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Halo! Ini adalah profil $name ($nim) mahasiswa $major.")
                }
                context.startActivity(Intent.createChooser(intent, "Bagikan lewat..."))
            }
        )

        // 2. ACTION_VIEW: Buka URL
        IntentButton(
            label = "Kunjungi GitHub",
            description = "ACTION_VIEW (URL)",
            icon = Icons.Default.Public,
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/muftifaris"))
                context.startActivity(intent)
            }
        )

        // 3. ACTION_SENDTO: Kirim Email
        IntentButton(
            label = "Kirim Email",
            description = "ACTION_SENDTO",
            icon = Icons.Default.Email,
            onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:muftifarisjob@student.uns.ac.id")
                    putExtra(Intent.EXTRA_SUBJECT, "Tanya Praktikum PAB")
                }
                context.startActivity(intent)
            }
        )

        // 4. ACTION_VIEW: Lokasi Map
        IntentButton(
            label = "Lokasi Kampus",
            description = "ACTION_VIEW (Geo)",
            icon = Icons.Default.LocationOn,
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Informatika+UNS"))
                context.startActivity(intent)
            }
        )
        
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun IntentButton(
    label: String,
    description: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = label, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                Text(text = description, fontSize = 11.sp, fontStyle = FontStyle.Italic)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    PPAB02_L0124133_MuftiFarisMurtadhoTheme {
        StudentProfileScreen()
    }
}
