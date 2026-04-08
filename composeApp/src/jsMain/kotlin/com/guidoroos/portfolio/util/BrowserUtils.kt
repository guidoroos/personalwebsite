package com.guidoroos.portfolio.util

import AppLanguage
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.window
import org.w3c.dom.events.Event

fun isSystemInDarkMode(): Boolean {
    // This returns true if the browser/OS is set to dark mode
    return window.matchMedia("(prefers-color-scheme: dark)").matches
}

fun getBrowserLanguage(): AppLanguage {
    val browserLang = window.navigator.language.take(2).lowercase()

    return when (browserLang) {
        "nl" -> AppLanguage.NL
        "en" -> AppLanguage.EN
        else -> AppLanguage.EN
    }
}

@Composable
fun rememberWindowWidth(): Int {
    var width by remember { mutableStateOf(window.innerWidth) }
    DisposableEffect(Unit) {
        val listener = { _: Event -> width = window.innerWidth }
        window.addEventListener("resize", listener)
        onDispose { window.removeEventListener("resize", listener) }
    }
    return width
}