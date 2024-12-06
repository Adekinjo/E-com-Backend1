package com.kinjo.E_com_Backend.service;

import com.kinjo.E_com_Backend.dto.ProductDto;
import com.kinjo.E_com_Backend.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long productId, ProductDto updatedProduct);

    void deleteProduct(Long productId);
}
