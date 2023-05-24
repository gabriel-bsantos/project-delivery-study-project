package com.composetest.advicesapp

import com.composetest.advicesapp.domain.repository.AdviceRepository
import com.composetest.advicesapp.ui.screens.main.MainScreenViewModel
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class MainScreenViewModelUnitTest {

    internal class FakeAdviceRepository(private val answer: String) : AdviceRepository {
        override suspend fun getRandomAdvice(): NetworkResponse<String, String> {
            return NetworkResponse.Success(
                body = answer,
                response = Response.success(answer)
            )
        }
    }

    private val testScope = TestScope()
    
    @Test
    fun `getRandomAdvice() from repository should be invoked`() = testScope.runTest(
        dispatchTimeoutMs = 10000L
    ) {
        val wantedResponse = "Test Advice"
        val fakeRepository = FakeAdviceRepository(wantedResponse)
        val viewModel = MainScreenViewModel(fakeRepository)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.adviceText.collect { adviceText ->
                if(adviceText != null)
                assertEquals(wantedResponse, adviceText)
            }
        }
        viewModel.getAdviceText()
    }
}