package com.store.validation

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [ProductNameValidator::class])
@Target(FIELD)
@Retention(RUNTIME)
annotation class ValidProductName(
    val message: String = "Name must not contain boolean values or numbers",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)