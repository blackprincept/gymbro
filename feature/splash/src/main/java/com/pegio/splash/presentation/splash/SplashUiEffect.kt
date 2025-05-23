package com.pegio.splash.presentation.splash

sealed interface SplashUiEffect {
    data object NavigateToHome : SplashUiEffect
    data object NavigateToAuth : SplashUiEffect
    data object NavigateToRegister : SplashUiEffect
}