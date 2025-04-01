package com.cursokotlin.composetesting.components

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class MyComponentTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeRule.setContent {
            MyComponent()
        }
    }
}