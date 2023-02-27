package com.mongoding.authservice.repository

import com.mongoding.authservice.domain.entity.AuthEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AuthRepository: JpaRepository<AuthEntity, Long> {
    fun findByEmail(email: String): Optional<AuthEntity>
}