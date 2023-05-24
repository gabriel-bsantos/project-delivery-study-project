package com.composetest.advicesapp

import com.composetest.advicesapp.ui.core.allToLowercase
import com.composetest.advicesapp.ui.core.allToUppercase
import org.junit.Test

class StringExtensionsUnitTest {
    @Test
    fun `on allToUpperCase() returns a string in upper case`() {
        val input = "hello world"
        val expected = "HELLO WORLD"

        val actual = input.allToUppercase()

        assert(actual == expected)
    }

    @Test
    fun `on allToLowerCase() return a string in lower case`(){
        val input = "HELLO WORLD"
        val expected = "hello world"

        val actual = input.allToLowercase()

        assert(actual == expected)
    }

}