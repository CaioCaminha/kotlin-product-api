package com.caio.productapi.dto

import com.caio.productapi.entity.Product
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDto(
    val title: String,
    val description: String,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val value: BigDecimal
){

    fun convertToEntity(): Product{
        return Product(title = this.title,
            description = this.description,
            createdAt = this.createdAt,
            value = this.value)
    }

}