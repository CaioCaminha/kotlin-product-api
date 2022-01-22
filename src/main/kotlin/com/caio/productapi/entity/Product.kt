package com.caio.productapi.entity

import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "product")
data class Product(
    val id: Long? = null,
    val title: String,
    val description: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val value: BigDecimal
);