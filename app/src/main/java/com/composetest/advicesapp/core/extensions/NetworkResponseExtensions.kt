package com.composetest.advicesapp.core.extensions

import com.haroldadmin.cnradapter.NetworkResponse
import java.io.IOException

fun <S: Any, E: Any, M: Any> NetworkResponse<S, E>.convert(func: (S) -> M): NetworkResponse<M, E> {
    return when(this){
        is NetworkResponse.Success -> NetworkResponse.Success(func(body), response)
        else -> NetworkResponse.UnknownError(IOException(), response = null)
    }
}