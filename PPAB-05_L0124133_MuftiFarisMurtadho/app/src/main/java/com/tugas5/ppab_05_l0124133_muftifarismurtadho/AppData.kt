package com.tugas5.ppab_05_l0124133_muftifarismurtadho

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.tugas5.ppab_05_l0124133_muftifarismurtadho.R

@Immutable
data class AppItem(
    val name: String,
    val category: String,
    val rating: Float,
    val installs: String,
    val iconColor: Color,
    val iconLabel: String,
    @DrawableRes val iconRes: Int,
    val isFree: Boolean = true,
    val price: String = "Free"
)

@Immutable
data class AppSection(
    val title: String,
    val subtitle: String = "",
    val apps: List<AppItem>
)

val dummyApps = listOf(
    AppItem("WhatsApp", "Communication", 4.2f, "5B+", Color(0xFF25D366), "WA", R.mipmap.wa),
    AppItem("Instagram", "Social", 4.0f, "1B+", Color(0xFFE1306C), "IG", R.mipmap.instagram),
    AppItem("YouTube", "Video", 4.3f, "10B+", Color(0xFFFF0000), "YT", R.mipmap.youtube),
    AppItem("Spotify", "Music", 4.4f, "1B+", Color(0xFF1DB954), "SP", R.mipmap.spotify),
    AppItem("TikTok", "Entertainment", 4.5f, "1B+", Color(0xFF010101), "TK", R.mipmap.tiktok),
    AppItem("Telegram", "Communication", 4.5f, "1B+", Color(0xFF2CA5E0), "TG", R.mipmap.telegram),
    AppItem("Netflix", "Entertainment", 4.3f, "1B+", Color(0xFFE50914), "NF", R.mipmap.netflix),
    AppItem("Canva", "Design", 4.6f, "500M+", Color(0xFF00C4CC), "CV", R.mipmap.canva),
)

val popularApps = listOf(
    AppItem("Google Maps", "Navigation", 4.3f, "10B+", Color(0xFF4285F4), "GM", R.mipmap.gmaps),
    AppItem("Zoom", "Business", 4.2f, "500M+", Color(0xFF2D8CFF), "ZM", R.mipmap.zoom),
    AppItem("Microsoft Teams", "Productivity", 4.0f, "500M+", Color(0xFF6264A7), "MT", R.mipmap.mt),
    AppItem("Shopee", "Shopping", 4.4f, "500M+", Color(0xFFEE4D2D), "SH", R.mipmap.shopee),
    AppItem("Gojek", "Lifestyle", 4.3f, "100M+", Color(0xFF00AA13), "GJ", R.mipmap.gojek),
    AppItem("Grab", "Transport", 4.2f, "100M+", Color(0xFF00B14F), "GB", R.mipmap.grab),
    AppItem("Tokopedia", "Shopping", 4.3f, "100M+", Color(0xFF42B549), "TP", R.mipmap.tokopedia),
    AppItem("Dana", "Finance", 4.5f, "100M+", Color(0xFF118EEA), "DN", R.mipmap.dana),
)

val suggestedApps = listOf(
    AppItem("Notion", "Productivity", 4.5f, "50M+", Color(0xFF000000), "NO", R.mipmap.notion),
    AppItem("Duolingo", "Education", 4.7f, "500M+", Color(0xFF58CC02), "DL", R.mipmap.duolingo),
    AppItem("Headspace", "Health", 4.6f, "10M+", Color(0xFFF47D31), "HS", R.mipmap.headspace),
    AppItem("1Password", "Tools", 4.7f, "10M+", Color(0xFF1A8CFF), "1P", R.mipmap.password),
    AppItem("Figma", "Design", 4.5f, "10M+", Color(0xFF0ACF83), "FG", R.mipmap.figma),
    AppItem("Obsidian", "Productivity", 4.6f, "5M+", Color(0xFF7C3AED), "OB", R.mipmap.obsidian),
)

val appSections = listOf(
    AppSection("Recommended for You", "Based on your interests", dummyApps),
    AppSection("Popular Apps", "Top picks this week", popularApps),
    AppSection("Suggested for You", "You might also like", suggestedApps),
)

val categoryTabs = listOf("For You", "Top Charts", "Children", "Premium", "Categories", "Editors' Choice")
