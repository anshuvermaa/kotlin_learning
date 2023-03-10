package com.example.nested_routes.navigation.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.nested_routes.navigation.HOME_GRAPH_ROUTE
import com.example.nested_routes.navigation.ROOT_GRAPH_ROUTE


@Composable

fun SetupNavGraph(
    navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        homeNavGraph(navController = navController)
        authNavGraph(navController = navController)
    }
}