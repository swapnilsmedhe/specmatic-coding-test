package com.store.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class InvalidProductTypeException(value: String) : RuntimeException("Invalid product type: $value")
