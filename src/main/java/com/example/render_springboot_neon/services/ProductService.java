package com.example.render_springboot_neon.services;

import com.example.render_springboot_neon.Dto.ProductDto;

import java.util.List;

public interface ProductService {
ProductDto createProduct(ProductDto productDto);
void deleteProduct(Long productId);
ProductDto getProduct (Long productId);
List<ProductDto> getAllProducts ();
ProductDto updateProduct (Long productId, ProductDto updateProductDto);
}
