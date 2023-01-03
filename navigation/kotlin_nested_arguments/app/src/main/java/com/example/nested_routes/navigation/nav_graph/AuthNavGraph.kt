package com.example.nested_routes.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.nested_routes.navigation.AUTH_GRAPH_ROUTE
import com.example.nested_routes.navigation.Screen
import com.example.nested_routes.screens.LoginScreen
import com.example.nested_routes.screens.SignUpScreen


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = Screen.Login.route,
    route= AUTH_GRAPH_ROUTE
    ){
        composable(
            route=Screen.Login.route
        ){
            LoginScreen(navController= navController)
        }
        composable(
            route=Screen.SignUp.route
        ){
            SignUpScreen(navController=navController)
        }
    }
}