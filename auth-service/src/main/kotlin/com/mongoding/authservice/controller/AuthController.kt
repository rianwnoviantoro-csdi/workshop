package com.mongoding.authservice.controller

import com.mongoding.authservice.domain.dto.request.ReqLoginDto
import com.mongoding.authservice.domain.dto.request.ReqRegisterDto
import com.mongoding.authservice.domain.dto.response.ResLoginDto
import com.mongoding.authservice.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/auth")
class AuthController(val authService: AuthService) {
    @PostMapping("/register")
    fun register(@Valid @RequestBody request: ReqRegisterDto): ResponseEntity<String> {
        println(request.email)
        println(request.password)

        authService.registerUser(request)

        return ResponseEntity.ok("Success")
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: ReqLoginDto): ResponseEntity<ResLoginDto> {
        val result = authService.loginUser(request)

        return ResponseEntity.ok(result)
    }
}