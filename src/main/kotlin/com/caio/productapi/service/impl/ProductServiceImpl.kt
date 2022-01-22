package com.caio.productapi.service.impl

import com.caio.productapi.dto.ProductDto
import com.caio.productapi.entity.Product
import com.caio.productapi.repository.ProductRepository
import com.caio.productapi.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriBuilderFactory
import org.springframework.web.util.UriComponentsBuilder

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository
): ProductService {



    override fun getProduct(id: Long): ResponseEntity<Any>{
        return try {
            val product: Product = productRepository.getById(id)
            ResponseEntity.ok(product)
        }catch (e: Exception){
            ResponseEntity.badRequest().body("Error fetching the product")
        }
    }

    override fun getProducts(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(productRepository.findAll());
        }catch (e: Exception){
            ResponseEntity.badRequest().body("Error fetching the products")
        }
    }

    override fun insertProduct(product: ProductDto, uriBuilder: UriComponentsBuilder): ResponseEntity<Any> {
        return try {
            val entity  = product.convertToEntity()
            val entitySaved = productRepository.save(entity)
            return ResponseEntity.created(uriBuilder.path("/product/${entitySaved.id}").build().toUri()).body(entity)
        }catch (e: Exception){
            ResponseEntity.badRequest().body("Error inserting the product")
        }
    }

    override fun updateProduct(id: Long): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: Long): ResponseEntity<Any> {
        TODO("Not yet implemented")
    }


}