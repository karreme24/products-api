package com.example.render_springboot_neon.services.imp;

import com.example.render_springboot_neon.Dto.ProductDto;

import com.example.render_springboot_neon.Mapper.ProductMapper;
import com.example.render_springboot_neon.exceptions.notFoudException;
import com.example.render_springboot_neon.services.ProductService;
import com.example.render_springboot_neon.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.render_springboot_neon.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    ProductMapper productMapper;
    ProductRepository productRepository;



    @Override
    public ProductDto createProduct( ProductDto productDto) {
    Product product = productMapper.mapToProduct(productDto);
    Product saveProduct = productRepository.save(product);
    return productMapper.mapToProductDto(saveProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new notFoudException("no product with the id: " + productId));

        productRepository.deleteById(productId);

    }

    @Override
    public ProductDto getProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(()->
                new notFoudException("no product with the id: "+productId));
       return productMapper.mapToProductDto(product);

    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        return allProducts.stream().map(product -> productMapper.mapToProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updateProductDto) {

        Product product = productRepository.findById(productId).orElseThrow(() ->
                new notFoudException("no product with the id: " + productId));

        product.setName(updateProductDto.getName());
        product.setDescription(updateProductDto.getDescription());
        product.setPrice(updateProductDto.getPrice());

        Product updateProduct = productRepository.save(product);


        return productMapper.mapToProductDto(updateProduct);
    }


}
