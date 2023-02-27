package com.mongoding.authservice.service

import com.mongoding.authservice.domain.dto.request.ReqLoginDto
import com.mongoding.authservice.domain.dto.request.ReqRegisterDto
import com.mongoding.authservice.domain.dto.response.ResLoginDto

interface AuthService {
    fun registerUser(request: ReqRegisterDto)

    fun loginUser(request: ReqLoginDto): ResLoginDto
}