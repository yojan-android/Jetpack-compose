package com.yojan.learning.ui.fake.fakePerson.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yojan.learning.networking.networkModel.UiState
import com.yojan.learning.ui.fake.fakePerson.viewModel.FakePersonViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UploadFakeUserUI(
    viewModel: FakePersonViewModel = hiltViewModel()
) {
    val submitState = viewModel.obsSubmitPersonDetails.collectAsStateWithLifecycle().value
    var showErrors by remember { mutableStateOf(false) }
    val isLoading = submitState is UiState.Loading

    LaunchedEffect(submitState) {
        if(submitState is UiState.Success) {
            delay(2000)
            viewModel.firstName = ""
            viewModel.midName = ""
            viewModel.lastName = ""
            viewModel.resetUi()
        }
    }

    Scaffold(topBar = { TopAppBar(title = { Text(text = "Person Details") }) }) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {

            OutlinedTextField(
                value = viewModel.firstName,
                onValueChange = {viewModel.firstName = it},
                label = {Text(text = "First Name")},
                isError = showErrors && viewModel.firstName.isBlank(),
                supportingText = { if(showErrors && viewModel.firstName.isBlank()) Text("Required")
                },
                singleLine = true,
                enabled = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = viewModel.midName,
                onValueChange = {viewModel.midName = it},
                label = {Text(text = "Middle Name")},
                isError = showErrors && viewModel.midName.isBlank(),
                supportingText = { if(showErrors && viewModel.midName.isBlank()) Text("Required")
                },
                singleLine = true,
                enabled = true,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = viewModel.lastName,
                onValueChange = {viewModel.lastName = it},
                label = {Text(text = "Last Name")},
                isError = showErrors && viewModel.lastName.isBlank(),
                supportingText = { if(showErrors && viewModel.lastName.isBlank()) Text("Required")
                },
                singleLine = true,
                enabled = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                showErrors = true
                if(viewModel.firstName.isNotBlank() && viewModel.midName.isNotBlank() && viewModel.lastName.isNotBlank()) {
                    viewModel.sendPersonDetails()
                } },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) { if(isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colorScheme.onPrimary)
                Spacer(Modifier.width(8.dp))
                Text("Submitting...")
                } else {
                Text("Submit")
                }
            }
            when(submitState) {
                is UiState.Success -> Text(
                    text  = "✓ ${submitState.response.firstName} ${submitState.response.lastName} submitted!",
                    color = MaterialTheme.colorScheme.primary
                )
                is UiState.Error -> Text(
                    text  = submitState.message,
                    color = MaterialTheme.colorScheme.error
                )
                else -> Unit
            }
        }
    }
}