package com.caio.productapi.service

import com.caio.productapi.dto.ProductDto
import org.springframework.http.ResponseEntity
import org.springframework.web.util.UriComponentsBuilder


interface ProductService {
    fun getProduct(id: Long): ResponseEntity<Any>
    fun getProducts(): ResponseEntity<Any>
    fun insertProduct(product: ProductDto, uriBuilder: UriComponentsBuilder): ResponseEntity<Any>
    fun updateProduct(id: Long): ResponseEntity<Any>
    fun deleteProduct(id: Long): ResponseEntity<Any>
}