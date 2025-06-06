package com.example.render_springboot_neon.repository;

import com.example.render_springboot_neon.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {
}
