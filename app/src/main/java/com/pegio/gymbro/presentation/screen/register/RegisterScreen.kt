package com.pegio.gymbro.presentation.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pegio.gymbro.domain.model.User
import com.pegio.gymbro.presentation.components.DropdownMenu
import com.pegio.gymbro.presentation.components.ProfileImage
import com.pegio.gymbro.presentation.theme.GymBroTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState
        .collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collectLatest { effect ->
            when (effect) {
                RegisterUiEffect.NavigateToHome -> onRegisterSuccess()
            }
        }
    }

    RegisterForm(state = uiState, onEvent = viewModel::onEvent)
}

@Composable
@ExperimentalMaterial3Api
fun RegisterForm(
    state: RegisterUiState,
    onEvent: (RegisterUiEvent) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
                    .clickable { onEvent(RegisterUiEvent.OnProfilePhotoClicked) },
                contentAlignment = Alignment.Center
            ) {
                ProfileImage(
                    imageUrl = state.user.imgProfileUrl,
                    modifier = Modifier
                        .fillMaxSize()
                )

                if (state.user.imgProfileUrl == null)
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        tint = Color.White,
                        contentDescription = "Camera",
                        modifier = Modifier
                            .size(50.dp)
                    )
            }

            Spacer(modifier = Modifier.width(16.dp))

            TextButton(onClick = { }) {
                Text(text = "Click to choose profile picture")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = state.user.username,
            onValueChange = { onEvent(RegisterUiEvent.OnUsernameChanged(it)) },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = state.user.age,
            onValueChange = { onEvent(RegisterUiEvent.OnAgeChanged(it)) },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        DropdownMenu(
            options = User.Gender.entries,
            onSelectionChanged = { onEvent(RegisterUiEvent.OnGenderChanged(it)) },
            label = { Text(text = "Gender") },
            selectedOption = state.user.gender?.name
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = state.user.heightCm,
            onValueChange = { onEvent(RegisterUiEvent.OnHeightChanged(it)) },
            label = { Text("Height (cm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = state.user.weightKg,
            onValueChange = { onEvent(RegisterUiEvent.OnWeightChanged(it)) },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onEvent(RegisterUiEvent.OnSubmit) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }
    }
}

@Preview
@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun RegisterFormPreview() {
    GymBroTheme {
        RegisterForm(
            state = RegisterUiState(),
            onEvent = {}
        )
    }
}