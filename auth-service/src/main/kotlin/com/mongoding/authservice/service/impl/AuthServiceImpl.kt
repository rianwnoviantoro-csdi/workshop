package com.mongoding.authservice.service.impl

import com.mongoding.authservice.domain.dto.request.ReqLoginDto
import com.mongoding.authservice.domain.dto.request.ReqRegisterDto
import com.mongoding.authservice.domain.dto.response.ResLoginDto
import com.mongoding.authservice.domain.entity.AuthEntity
import com.mongoding.authservice.repository.AuthRepository
import com.mongoding.authservice.service.AuthService
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class AuthServiceImpl(val authRepository: AuthRepository): AuthService {
    override fun registerUser(request: ReqRegisterDto) {
        val auth: AuthEntity = AuthEntity(
            email = request.email,
            password = request.password
        )
        authRepository.save(auth)
    }

    override fun loginUser(request: ReqLoginDto): ResLoginDto {
        val authEntity: Optional<AuthEntity> = authRepository.findByEmail(request.email)

        if (authEntity.isPresent) {
            val result: ResLoginDto = ResLoginDto(
                id = authEntity.get().id!!,
                email = authEntity.get().email
            )

            return result
        }

        return ResLoginDto(id = 0, email = "")
    }
}