package com.example.cricket.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object SendOTP

    @Serializable
    object verifyOTP

    @Serializable
    object  HomeScreen
}