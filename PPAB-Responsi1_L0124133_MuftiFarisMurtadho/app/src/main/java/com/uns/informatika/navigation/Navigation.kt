package com.uns.informatika.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.uns.informatika.ui.screens.detail.DetailScreen
import com.uns.informatika.ui.screens.home.HomeScreen
import com.uns.informatika.ui.screens.list.ListScreen
import com.uns.informatika.ui.screens.profile.ProfileScreen
import com.uns.informatika.viewmodel.DetailViewModel
import com.uns.informatika.viewmodel.HomeViewModel
import com.uns.informatika.viewmodel.ListViewModel
import com.uns.informatika.viewmodel.ProfileViewModel

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object List : Screen("list")
    object Detail : Screen("detail/{itemId}") {
        fun createRoute(itemId: Int) = "detail/$itemId"
    }
    object Profile : Screen("profile")
}

sealed class BottomNavItem(
    val screen: Screen,
    val label: String,
    val iconUnselected: ImageVector,
    val iconSelected: ImageVector
) {
    object Home : BottomNavItem(
        screen = Screen.Home,
        label = "Home",
        iconUnselected = Icons.Outlined.Home,
        iconSelected = Icons.Filled.Home
    )
    object List : BottomNavItem(
        screen = Screen.List,
        label = "Daftar",
        iconUnselected = Icons.AutoMirrored.Outlined.List,
        iconSelected = Icons.AutoMirrored.Filled.List
    )
    object Profile : BottomNavItem(
        screen = Screen.Profile,
        label = "Profil",
        iconUnselected = Icons.Outlined.Person,
        iconSelected = Icons.Filled.Person
    )
}

@Composable
fun InformaticsNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(viewModel = viewModel, onNavigateToList = {
                navController.navigate(Screen.List.route)
            })
        }

        composable(Screen.List.route) {
            val viewModel: ListViewModel = viewModel()
            ListScreen(
                viewModel = viewModel,
                onItemClick = { itemId ->
                    navController.navigate(Screen.Detail.createRoute(itemId))
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: return@composable
            val viewModel: DetailViewModel = viewModel()
            DetailScreen(
                itemId = itemId,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Profile.route) {
            val viewModel: ProfileViewModel = viewModel()
            ProfileScreen(viewModel = viewModel)
        }
    }
}
