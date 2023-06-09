package com.composetest.advicesapp.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.composetest.advicesapp.R
import com.composetest.advicesapp.domain.repository.AdviceRepository
import com.composetest.advicesapp.ui.core.allToUppercase
import com.composetest.advicesapp.ui.theme.Typography
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.Response

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    val advice = viewModel.adviceText.collectAsStateWithLifecycle()
    val isLoading = viewModel.isLoading.collectAsStateWithLifecycle()

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {

        if(!isLoading.value){
            Text(
                advice.value.allToUppercase(),
                style = Typography.headlineMedium,
                textAlign = TextAlign.Center,
            )
        } else {
            CircularProgressIndicator()
        }
        Button(
            content = {
                      Image(
                          painter = painterResource(
                              id = R.drawable.reload_ic
                          ), contentDescription = "Reload button",
                      )
            }, onClick = {
                viewModel.getAdviceText()
            }, modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        MainScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = mainViewModelPreviewProvider()
        )
    }
}

@Composable
private fun mainViewModelPreviewProvider(): MainScreenViewModel {
    class FakeAdviceRepository(): AdviceRepository{
        override suspend fun getRandomAdvice(): NetworkResponse<String, String> {
            return NetworkResponse.Success(
                "This is a fake advice",
                response = Response.success("This is a fake advice")
            )
        }
    }
    return MainScreenViewModel(adviceRepository = FakeAdviceRepository())
}

