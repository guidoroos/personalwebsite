package com.guidoroos.portfolio.util

import kotlinx.browser.window

fun isSystemInDarkMode(): Boolean {
    // This returns true if the browser/OS is set to dark mode
    return window.matchMedia("(prefers-color-scheme: dark)").matches
}