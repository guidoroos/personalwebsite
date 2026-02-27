package com.guidoroos.portfolio.ui.component

import LocalAppTheme
import LocalStyles
import androidx.compose.runtime.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun ActionIcon(
    svgName: String,
    styleModifier: StyleScope.() -> Unit = {},
    onClickAction: () -> Unit
) {
    val theme = LocalAppTheme.current
    val styles = LocalStyles.current

    Div(attrs = {
        classes(styles.iconMaskBase, styles.hoverIcon)

        onClick { onClickAction() }

        style {
            // Dynamic mask path based on the svgName
            val iconPath = "url('$svgName.svg')"
            property("-webkit-mask-image", iconPath)
            property("mask-image", iconPath)

            // Apply any extra overrides (like margin or specific color)
            styleModifier()
        }
    })
}