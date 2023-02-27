package com.mongoding.authservice.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "tbl_auth")
data class AuthEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "email", length = 100, columnDefinition = "VARCHAR")
    val email: String = "placeholder@mail.com",

    @Column(name = "password")
    val password: String,

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    val createdAt: Date? = null,

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updatedAt")
    val updatedAt: Date? = null
)
