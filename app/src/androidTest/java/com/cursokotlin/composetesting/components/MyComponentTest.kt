package com.cursokotlin.composetesting.components

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

class MyComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            MyComponent()
        }

        //FINDER
        composeTestRule.onNodeWithText("ElGG", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("add")

        composeTestRule.onAllNodesWithText(":")
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //ACTIONS
        composeTestRule.onNodeWithText("ElGG", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("e").onFirst().performClick()
        composeTestRule.onNodeWithText("ElGG").performTouchInput {
            doubleClick()
            longClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("ElGG").performScrollTo()
        composeTestRule.onNodeWithText("ElGG").performImeAction()
        composeTestRule.onNodeWithText("ElGG").performTextClearance()
        composeTestRule.onNodeWithText("ElGG").performTextInput("Se la come")
        composeTestRule.onNodeWithText("ElGG").performTextReplacement("Selacome")

        //ASSERTIONS
        composeTestRule.onNodeWithText("ElGG").assertExists()
        composeTestRule.onNodeWithText("ElGG").assertDoesNotExist()
        composeTestRule.onNodeWithText("ElGG").assertContentDescriptionContains("")
        composeTestRule.onNodeWithText("ElGG").assertContentDescriptionEquals("")
        composeTestRule.onNodeWithText("ElGG").assertIsDisplayed()
        composeTestRule.onNodeWithText("ElGG").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("ElGG").assertIsEnabled()
        composeTestRule.onNodeWithText("ElGG").assertIsNotEnabled()
        composeTestRule.onNodeWithText("ElGG").assertIsSelected()
        composeTestRule.onNodeWithText("ElGG").assertIsNotSelected()
        composeTestRule.onNodeWithText("ElGG").assertIsNotFocused()
        composeTestRule.onNodeWithText("ElGG").assertIsFocused()
        composeTestRule.onNodeWithText("ElGG").assertIsOn()
        composeTestRule.onNodeWithText("ElGG").assertIsOff()
        composeTestRule.onNodeWithText("ElGG").assertTextContains("")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsElGG() {
        composeTestRule.setContent {
            MyComponent()
        }
        composeTestRule.onNodeWithText("ElGG", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("ElGG", ignoreCase = true)
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainsGreeting() {
        composeTestRule.setContent {
            MyComponent()
        }

        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("ElGG")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas ElGG")
    }
}