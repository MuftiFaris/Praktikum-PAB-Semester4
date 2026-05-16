package com.tugas5.ppab_05_l0124133_muftifarismurtadho

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugas5.ppab_05_l0124133_muftifarismurtadho.components.AppCard
import com.tugas5.ppab_05_l0124133_muftifarismurtadho.components.AppListItem
import com.tugas5.ppab_05_l0124133_muftifarismurtadho.components.SectionHeader
import com.tugas5.ppab_05_l0124133_muftifarismurtadho.ui.theme.*

// ─── Bottom Nav Item Data ───────────────────────────────────────────────────

data class BottomNavItem(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem("Games", Icons.Filled.VideogameAsset, Icons.Outlined.VideogameAsset),
    BottomNavItem("Apps", Icons.Filled.Apps, Icons.Outlined.Apps),
    BottomNavItem("Offers", Icons.Filled.LocalOffer, Icons.Outlined.LocalOffer),
    BottomNavItem("Books", Icons.Filled.MenuBook, Icons.Outlined.MenuBook),
)

// ─── HomeScreen ─────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    var selectedNavItem by remember { mutableIntStateOf(1) } // "Apps" selected by default

    Scaffold(
        topBar = {
            Surface(
                shadowElevation = 2.dp,
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    // ── Search Bar ──────────────────────────────────────
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .statusBarsPadding()
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                            .padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Search Field
                        Surface(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(50),
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            tonalElevation = 0.dp
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Logo Placeholder
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFF4285F4)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("G", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = "Search apps & games",
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontSize = 15.sp
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        // Profile Avatar
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primary),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "M",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }

                    // ── Category Tabs ───────────────────────────────────
                    ScrollableTabRow(
                        selectedTabIndex = selectedTab,
                        edgePadding = 16.dp,
                        divider = {},
                        indicator = { tabPositions ->
                            if (selectedTab < tabPositions.size) {
                                TabRowDefaults.SecondaryIndicator(
                                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                                    color = MaterialTheme.colorScheme.primary,
                                    height = 2.dp
                                )
                            }
                        },
                        containerColor = MaterialTheme.colorScheme.background
                    ) {
                        categoryTabs.forEachIndexed { index, title ->
                            Tab(
                                selected = selectedTab == index,
                                onClick = { selectedTab = index },
                                text = {
                                    Text(
                                        text = title,
                                        fontWeight = if (selectedTab == index) FontWeight.SemiBold else FontWeight.Normal,
                                        fontSize = 13.sp
                                    )
                                },
                                selectedContentColor = MaterialTheme.colorScheme.primary,
                                unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    }
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.background,
                tonalElevation = 4.dp
            ) {
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedNavItem == index,
                        onClick = { selectedNavItem = index },
                        icon = {
                            Icon(
                                imageVector = if (selectedNavItem == index) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.label
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                fontSize = 11.sp
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            // ── Banner / Feature Highlight ──────────────────────────────
            item(key = "banner", contentType = "banner") {
                FeaturedBanner()
            }

            // ── Dynamic Sections (Lazy Layout Implementation) ───────────
            appSections.forEachIndexed { sectionIndex, section ->
                item(key = "header_${section.title}", contentType = "header") {
                    Spacer(modifier = Modifier.height(if (sectionIndex == 0) 8.dp else 16.dp))
                    SectionHeader(
                        title = section.title,
                        subtitle = section.subtitle,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }

                // Render horizontal rows using LazyRow nested in LazyColumn
                item(key = "row_${section.title}_$sectionIndex", contentType = "horizontal_row") {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        items(
                            items = section.apps,
                            key = { app -> "card_${app.name}_$sectionIndex" },
                            contentType = { "card_item" }
                        ) { app ->
                            AppCard(app = app)
                        }
                    }
                }
            }

            // ── Vertical List Section (More Lazy Layout) ────────────────
            item(key = "top_charts_header", contentType = "header") {
                Spacer(modifier = Modifier.height(24.dp))
                SectionHeader(
                    title = "Top Charts",
                    subtitle = "Most popular apps right now",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            itemsIndexed(
                items = popularApps.take(5),
                key = { _, app -> "list_${app.name}_top" },
                contentType = { _, _ -> "list_item" }
            ) { index, app ->
                AppListItem(
                    app = app,
                    index = index + 1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                if (index < 4) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        color = MaterialTheme.colorScheme.outline.copy(alpha = 0.12f),
                        thickness = 0.5.dp
                    )
                }
            }

            // ── Quick Access Section ─────────────────────────────────
            item(key = "quick_access", contentType = "quick_access") {
                Spacer(modifier = Modifier.height(16.dp))
                QuickAccessSection()
            }
        }
    }
}

// ─── Featured Banner ─────────────────────────────────────────────────────────

@Composable
fun FeaturedBanner() {
    val featuredApp = dummyApps[3] // Spotify

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A2E))
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left: info
                Column(modifier = Modifier.weight(1f)) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = featuredApp.iconColor.copy(alpha = 0.2f),
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(
                            text = "Editor's Choice",
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF1DB954),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 10.sp
                        )
                    }
                    Text(
                        text = featuredApp.name,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = featuredApp.category,
                        color = Color.White.copy(alpha = 0.6f),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF01875F),
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 6.dp),
                        modifier = Modifier.height(34.dp)
                    ) {
                        Text(
                            text = "Install",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                // Right: icon placeholder
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(22.dp))
                        .background(featuredApp.iconColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(featuredApp.iconLabel, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                }
            }
        }
    }
}

// ─── Quick Access / Categories ───────────────────────────────────────────────

private data class QuickItem(val label: String, val icon: ImageVector, val color: Color)

@Composable
fun QuickAccessSection() {
    val items = remember {
        listOf(
            QuickItem("Top Free", Icons.Filled.TrendingUp, Color(0xFF4285F4)),
            QuickItem("Top Paid", Icons.Filled.AttachMoney, Color(0xFF34A853)),
            QuickItem("New", Icons.Filled.FiberNew, Color(0xFFEA4335)),
            QuickItem("Events", Icons.Filled.Event, Color(0xFFFBBC04)),
        )
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionHeader(title = "Explore", showMoreButton = false)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items.forEach { item ->
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = item.color.copy(alpha = 0.08f))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = item.color,
                            modifier = Modifier.size(22.dp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.label,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
