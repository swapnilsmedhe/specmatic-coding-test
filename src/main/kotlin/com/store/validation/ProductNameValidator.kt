package com.store.validation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class ProductNameValidator : ConstraintValidator<ValidProductName, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrBlank()) return false

        return value.all { it.isLetter() || it.isWhitespace() } && !isBoolean(value) && !isNumeric(value)
    }

    private fun isBoolean(value: String): Boolean {
        return value.equals("true", ignoreCase = true) || value.equals("false", ignoreCase = true)
    }

    private fun isNumeric(value: String): Boolean {
        return value.all { it.isDigit() }
    }
}
