package com.cursokotlin.composetesting.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun MyComponent() {
    var name by rememberSaveable { mutableStateOf("ElGG") }

    Column(Modifier.fillMaxSize().padding(24.dp)) {
        TextField(value = name, onValueChange = { name = it }, Modifier.testTag("textFieldName").fillMaxWidth())
        Text("Te llamas $name", Modifier.testTag("textGreeting"))
    }
}