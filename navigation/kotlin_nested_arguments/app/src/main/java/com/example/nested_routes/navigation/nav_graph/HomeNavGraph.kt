package com.example.nested_routes.navigation.nav_graph

import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.nested_routes.navigation.DETAIL_ARGUMENT_KEY2
import com.example.nested_routes.navigation.HOME_GRAPH_ROUTE
import com.example.nested_routes.navigation.Screen
import com.example.nested_routes.screens.DetailScreen
import com.example.nested_routes.screens.HomeScreen
import com.example.nested_routes.navigation.DETAIL_ARGUMENT_KEY as DETAIL_ARGUMENT_KEY1

fun NavGraphBuilder.homeNavGraph(
    navController:NavHostController
){
    navigation(
        startDestination = Screen.Home.route,
        route= HOME_GRAPH_ROUTE
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController=navController)
        }
        composable(route=Screen.Detail.route,
        arguments = listOf(
            navArgument(DETAIL_ARGUMENT_KEY1){
                type= NavType.StringType
                defaultValue=0
            },
            navArgument(DETAIL_ARGUMENT_KEY2){
                type= NavType.StringType
                defaultValue="anshu"
            }
        )
            ){
            DetailScreen(navController = navController)
        }
    }
}