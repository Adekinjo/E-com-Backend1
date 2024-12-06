package com.kinjo.E_com_Backend.repository;

import com.kinjo.E_com_Backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Long> {
}
