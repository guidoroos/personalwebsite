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
        onClick { onClickAction() }

        classes(styles.hoverIcon)

        style {
            display(DisplayStyle.Flex) // Change to Flex to center the mask perfectly
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)

            width(32.px)
            height(32.px)
            cursor("pointer")

            val iconPath = "url('$svgName.svg')"
            property("-webkit-mask-image", iconPath)
            property("mask-image", iconPath)
            property("mask-repeat", "no-repeat")
            property("mask-position", "center")
            property("mask-size", "95%")


            backgroundColor(theme.iconBase)
            styleModifier()
        }
    })
}