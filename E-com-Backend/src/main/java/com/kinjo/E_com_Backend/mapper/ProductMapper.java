package com.kinjo.E_com_Backend.mapper;

import com.kinjo.E_com_Backend.dto.ProductDto;
import com.kinjo.E_com_Backend.entity.Product;

public class ProductMapper {

    public static ProductDto mapProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getCategory(),
                product.getDescription(),
                product.getStock()
        );
    }
    public static  Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getProductPrice(),
                productDto.getCategory(),
                productDto.getDescription(),
                productDto.getInStock()
        );
    }
}
