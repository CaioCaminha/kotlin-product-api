package com.caio.productapi.controller

import com.caio.productapi.dto.ProductDto
import com.caio.productapi.service.ProductService
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/product-api",
    consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
    produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
class ProductController(
    val productService: ProductService
) {

    @GetMapping("/product/{id}")
    fun getProduct(
        @PathVariable("id") id: Long
    ):ResponseEntity<Any>{
        return productService.getProduct(id)
    }


    @GetMapping("/product")
    fun getProducts(
        @PageableDefault(sort = arrayOf("id"),
                        direction = Sort.Direction.ASC,
                        page = 0,
                        size = 10) pageable: Pageable
    ): ResponseEntity<Any>{
        return productService.getProducts(pageable)
    }

    @PostMapping("/product")
    fun insertProduct(@RequestBody productDto: ProductDto,
                      uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Any>{
        return productService.insertProduct(productDto, uriBuilder)
    }

    @PutMapping("/product/{id}")
    fun updateProduct(
        @PathVariable("id") id: Long,
        @RequestBody productDto: ProductDto
    ): ResponseEntity<Any>{
        return productService.updateProduct(id = id, product = productDto)
    }


    @DeleteMapping("/product/{id}")
    fun deleteProduct(@PathVariable id: Long): ResponseEntity<Any>{
        return productService.deleteProduct(id)
    }





}