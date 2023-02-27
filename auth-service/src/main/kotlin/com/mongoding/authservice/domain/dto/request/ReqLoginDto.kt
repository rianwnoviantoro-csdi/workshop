package com.mongoding.authservice.domain.dto.request

import javax.validation.constraints.NotNull

data class ReqLoginDto(
    @NotNull
    val email: String,

    @NotNull
    val password: String
)
