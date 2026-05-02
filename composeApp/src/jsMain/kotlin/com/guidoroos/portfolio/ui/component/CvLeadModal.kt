package com.guidoroos.portfolio.ui.component

import LocalAppTheme
import LocalLanguage
import androidx.compose.runtime.*
import kotlinx.browser.window
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.fetch.NO_CORS
import org.w3c.fetch.RequestInit
import org.w3c.fetch.RequestMode
import kotlin.js.json


@Composable
fun CvLeadModal(onClose: () -> Unit) {
    val theme = LocalAppTheme.current
    val language = LocalLanguage.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()
    var isSubmitting by remember { mutableStateOf(false) }

    Div(attrs = {
        style {
            position(Position.Fixed)
            top(0.px); left(0.px); width(100.vw); height(100.vh)
            backgroundColor(rgba(0, 0, 0, 0.75))
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.Center)
            alignItems(AlignItems.Center)
        }
        onClick { onClose() }
    }) {
        Div(attrs = {
            style {
                backgroundColor(theme.background)
                padding(2.5.cssRem)
                borderRadius(16.px)
                width(90.vw)
                maxWidth(450.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                property("box-shadow", "0 10px 25px rgba(0,0,0,0.2)")
            }
            onClick { it.stopPropagation() }
        }) {
            H2(attrs = { style { marginTop(0.px); color(theme.textPrimary) } }) {
                Text(if (language == AppLanguage.NL) "Download CV" else "Download CV")
            }

            P(attrs = { style { color(theme.textSecondary); marginBottom(1.5.cssRem) } }) {
                Text(if (language == AppLanguage.NL)
                    "Laat je gegevens achter om het CV te openen"
                else "Leave your details to open the CV")
            }

            Form(
                attrs = {
                    attr("enctype", "text/plain")
                    onSubmit { event ->
                        event.preventDefault() // Stop het herladen van de pagina

                        // Start de custom actie in een coroutine
                        scope.launch {
                            isSubmitting = true

                            window.fetch(
                                "https://script.google.com/macros/s/AKfycbzLn8AlycHmZ6GVM2OdxZOQyrUfshiOya2NZ7H2p5qyxy3Kt89Se-xwwP_96f9Gy31Ydw/exec",
                                RequestInit(
                                    method = "POST",
                                    mode = RequestMode.NO_CORS, // Cruciaal om de NetworkError te tackelen 🛡️
                                    headers = json("Content-Type" to "text/plain"), // Google script heeft moeite met application/json cors
                                    body = JSON.stringify(json("name" to name, "email" to email))
                                )
                            ).then {
                                isSubmitting = false
                                val url = if (language == AppLanguage.NL) {
                                    "https://rxresu.me/guidoroos/nl"
                                } else {
                                    "https://rxresu.me/guidoroos/en"
                                }
                                // Start de download
                                window.open(url, "_blank")
                                onClose() // Sluit modal
                            }
                        }
                    }
                }
            ) {
                // Naam
                Label(attrs = { style { display(DisplayStyle.Block); marginBottom(0.5.cssRem) } }) {
                    Text(if (language == AppLanguage.NL) "Naam" else "Name")
                }
                Input(type = InputType.Text, attrs = {
                    style {
                        width(100.percent); padding(0.8.cssRem); marginBottom(1.cssRem)
                        borderRadius(8.px); border(1.px, LineStyle.Solid, theme.border)
                    }
                    placeholder(if (language == AppLanguage.NL) "Je naam" else "Your name")
                    value(name)
                    onInput { name = it.value }
                    required()
                })

                // Email
                Label(attrs = { style { display(DisplayStyle.Block); marginBottom(0.5.cssRem) } }) {
                    Text("E-mail")
                }
                Input(type = InputType.Email, attrs = {
                    style {
                        width(100.percent); padding(0.8.cssRem); marginBottom(1.5.cssRem)
                        borderRadius(8.px); border(1.px, LineStyle.Solid, theme.border)
                    }
                    placeholder("guido@example.com")
                    value(email)
                    onInput { email = it.value }
                    required()
                })

                Button(attrs = {
                    style {
                        padding(0.8.cssRem, 1.5.cssRem); borderRadius(8.px)
                        cursor("pointer"); border(0.px); backgroundColor(theme.primary)
                        color(Color.white); fontWeight("bold"); alignSelf(AlignSelf.FlexEnd)
                    }
                }) {
                    Text(
                        if (isSubmitting) {
                            if (language == AppLanguage.NL) "Laden..." else "Loading..."
                        } else {
                            if (language == AppLanguage.NL) "Verstuur & Open" else "Submit & Open"
                        }
                    )
                }
            }
        }
    }
}

