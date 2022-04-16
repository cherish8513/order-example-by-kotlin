package com.carver.shopstudy.exception

import java.time.LocalDateTime

data class ErrorResponse(
    var resultCode: Int? = null,
    var httpMethod: String? = null,
    var message: String? = null,
    var path: String? = null,
    var timestamp: LocalDateTime? = null,
    var errors: MutableList<Error>? = mutableListOf()
)

data class Error(
    var field: String? = null,
    var message: String? = null,
    var value: Any? = null
)