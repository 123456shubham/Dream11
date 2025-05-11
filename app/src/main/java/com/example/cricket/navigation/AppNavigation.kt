package com.example.cricket.navigation


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cricket.screen.HomeScreen
import com.example.cricket.screen.SendOTP
import com.example.cricket.screen.VerifyOTPScreen


@Composable
fun AppNavigation (modifier: Modifier){

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SendOTP){
        composable<Routes.SendOTP>{
            SendOTP(modifier,navController)
        }

        composable<Routes.verifyOTP> {

            VerifyOTPScreen(modifier, navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(modifier, navController)
        }
    }
}