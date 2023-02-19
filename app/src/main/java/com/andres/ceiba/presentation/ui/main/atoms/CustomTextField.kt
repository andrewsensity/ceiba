package com.andres.ceiba.presentation.ui.main.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.presentation.theme.GreenCeiba


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = GreenCeiba,
            unfocusedIndicatorColor = GreenCeiba,
            focusedLabelColor = Color.Transparent,
            unfocusedLabelColor = GreenCeiba,
            disabledLabelColor = Color.Transparent,
            errorLabelColor = Color.Transparent,
            textColor = GreenCeiba
        ),
        label = {
            Text(
                text = label,
                modifier = Modifier.background(Color.Transparent),
                color = GreenCeiba
            )
        },
        shape = RoundedCornerShape(25.dp),
        modifier = modifier.fillMaxWidth(),
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon
    )
}

@Preview
@Composable
fun CustomTextFieldPrev() {
    var text by rememberSaveable { mutableStateOf(EMPTY) }
    CustomTextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = "Test"
    )
}