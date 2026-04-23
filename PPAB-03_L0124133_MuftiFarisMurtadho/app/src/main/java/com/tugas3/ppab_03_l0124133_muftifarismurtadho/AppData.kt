package com.tugas3.ppab_03_l0124133_muftifarismurtadho

import androidx.compose.ui.graphics.Color

data class AppItem(
    val name: String,
    val category: String,
    val rating: Float,
    val installs: String,
    val iconColor: Color,
    val iconLabel: String,
    val isFree: Boolean = true,
    val price: String = "Free"
)

data class AppSection(
    val title: String,
    val subtitle: String = "",
    val apps: List<AppItem>
)

val dummyApps = listOf(
    AppItem("WhatsApp", "Communication", 4.2f, "5B+", Color(0xFF25D366), "WA"),
    AppItem("Instagram", "Social", 4.0f, "1B+", Color(0xFFE1306C), "IG"),
    AppItem("YouTube", "Video", 4.3f, "10B+", Color(0xFFFF0000), "YT"),
    AppItem("Spotify", "Music", 4.4f, "1B+", Color(0xFF1DB954), "SP"),
    AppItem("TikTok", "Entertainment", 4.5f, "1B+", Color(0xFF010101), "TK"),
    AppItem("Telegram", "Communication", 4.5f, "1B+", Color(0xFF2CA5E0), "TG"),
    AppItem("Netflix", "Entertainment", 4.3f, "1B+", Color(0xFFE50914), "NF"),
    AppItem("Canva", "Design", 4.6f, "500M+", Color(0xFF00C4CC), "CV"),
)

val popularApps = listOf(
    AppItem("Google Maps", "Navigation", 4.3f, "10B+", Color(0xFF4285F4), "GM"),
    AppItem("Zoom", "Business", 4.2f, "500M+", Color(0xFF2D8CFF), "ZM"),
    AppItem("Microsoft Teams", "Productivity", 4.0f, "500M+", Color(0xFF6264A7), "MT"),
    AppItem("Shopee", "Shopping", 4.4f, "500M+", Color(0xFFEE4D2D), "SH"),
    AppItem("Gojek", "Lifestyle", 4.3f, "100M+", Color(0xFF00AA13), "GJ"),
    AppItem("Grab", "Transport", 4.2f, "100M+", Color(0xFF00B14F), "GB"),
    AppItem("Tokopedia", "Shopping", 4.3f, "100M+", Color(0xFF42B549), "TP"),
    AppItem("Dana", "Finance", 4.5f, "100M+", Color(0xFF118EEA), "DN"),
)

val suggestedApps = listOf(
    AppItem("Notion", "Productivity", 4.5f, "50M+", Color(0xFF000000), "NO"),
    AppItem("Duolingo", "Education", 4.7f, "500M+", Color(0xFF58CC02), "DL"),
    AppItem("Headspace", "Health", 4.6f, "10M+", Color(0xFFF47D31), "HS"),
    AppItem("1Password", "Tools", 4.7f, "10M+", Color(0xFF1A8CFF), "1P"),
    AppItem("Figma", "Design", 4.5f, "10M+", Color(0xFF0ACF83), "FG"),
    AppItem("Obsidian", "Productivity", 4.6f, "5M+", Color(0xFF7C3AED), "OB"),
)

val appSections = listOf(
    AppSection("Recommended for You", "Based on your interests", dummyApps),
    AppSection("Popular Apps", "Top picks this week", popularApps),
    AppSection("Suggested for You", "You might also like", suggestedApps),
)

val categoryTabs = listOf("For You", "Top Charts", "Children", "Premium", "Categories", "Editors' Choice")
