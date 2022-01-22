package com.caio.productapi.controller

import com.caio.productapi.dto.ProductDto
import com.caio.productapi.service.ProductService
import org.springframework.http.MediaType

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/product-api")
class ProductController(
    val productService: ProductService
) {

    @GetMapping("/product/{id}",
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getProduct():ResponseEntity<ProductDto>{
        return ResponseEntity.ok( ProductDto(
            title = "title",
            description = "title",
            value = BigDecimal("1000") )
        )
    }






}