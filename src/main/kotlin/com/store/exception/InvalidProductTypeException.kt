package com.store.exception

class InvalidProductTypeException(value: String) : RuntimeException("Invalid product type: $value")
