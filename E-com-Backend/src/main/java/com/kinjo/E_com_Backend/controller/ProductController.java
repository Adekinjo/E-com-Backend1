package com.kinjo.E_com_Backend.controller;

import com.kinjo.E_com_Backend.dto.ProductDto;
import com.kinjo.E_com_Backend.entity.Product;
import com.kinjo.E_com_Backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    // Build add product REST API
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
       ProductDto saveProduct =  productService.createProduct(productDto);
       return new ResponseEntity<>(saveProduct, HttpStatus.CREATED);
    }

    // Build get Product REST API
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
        ProductDto productDto = productService.getProductById(productId);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    //Build get all Products REST API
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //Build update Product REST API
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId,
                                                    @RequestBody ProductDto updatedProduct){
        ProductDto productDto = productService.updateProduct(productId,updatedProduct);
        return ResponseEntity.ok(productDto);
    }

    //Build delete Product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
         productService.deleteProduct(productId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
