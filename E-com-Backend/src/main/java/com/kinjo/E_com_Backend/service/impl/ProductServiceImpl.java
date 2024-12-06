package com.kinjo.E_com_Backend.service.impl;

import com.kinjo.E_com_Backend.dto.ProductDto;
import com.kinjo.E_com_Backend.entity.Product;
import com.kinjo.E_com_Backend.exception.ResourceNotFoundException;
import com.kinjo.E_com_Backend.mapper.ProductMapper;
import com.kinjo.E_com_Backend.repository.ProductRepository;
import com.kinjo.E_com_Backend.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
         Product saveProduct =  productRepository.save(product);

        return ProductMapper.mapProductDto(saveProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product =  productRepository.findById(productId).
                orElseThrow(() ->
                        new ResourceNotFoundException
                                ("Product is not exist with such id :"+productId));
        return ProductMapper.mapProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::mapProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product is not exist with such id: "+productId)
        );
        product.setProductName(updatedProduct.getProductName());
        product.setPrice(updatedProduct.getProductPrice());
        product.setCategory(updatedProduct.getCategory());
        product.setDescription(updatedProduct.getDescription());
        product.setStock(updatedProduct.getInStock());

        Product updatedProductObj =  productRepository.save(product);
        return ProductMapper.mapProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ResourceNotFoundException("Product is not exist with such id: "+productId));
        productRepository.deleteById(productId);
    }
}
