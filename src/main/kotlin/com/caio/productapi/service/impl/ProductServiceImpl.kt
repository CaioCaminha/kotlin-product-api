package com.caio.productapi.service.impl

import com.caio.productapi.dto.ProductDto
import com.caio.productapi.entity.Product
import com.caio.productapi.repository.ProductRepository
import com.caio.productapi.service.ProductService
import org.springframework.data.domain.Pageable
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
            val product = productRepository.findById(id)
            return if(product.isPresent){
                ResponseEntity.ok(product.get())
            }else{
                ResponseEntity.badRequest().body("Error fetching the product | Product not found")
            }
        }catch (e: Exception){
            ResponseEntity.badRequest().body("Error fetching the product")
        }
    }

    override fun getProducts(pageable: Pageable ): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(productRepository.findAll(pageable));
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

    override fun updateProduct(id: Long, productDto: ProductDto): ResponseEntity<Any> {
        return try {
            val product = productRepository.findById(id)
            if(product.isPresent) {
                productRepository.save(this.update(productDto = productDto, product = product.get()))
            }else{
                return ResponseEntity.badRequest().body("Error updating the product | Product not found")
            }
            return ResponseEntity.ok("Atualizado com sucesso")
        }catch (e: Exception){
            ResponseEntity.badRequest().body("Error updating the product")
        }
    }

    override fun deleteProduct(id: Long): ResponseEntity<Any> {
        return try{
            productRepository.deleteById(id)
            return ResponseEntity.ok("Successfully deleted")
        }catch (e: Exception){
            ResponseEntity.badRequest().body("Error deleting the product")
        }
    }


    fun update(productDto: ProductDto, product: Product ):Product{
        product.value = productDto.value
        return product
    }

}