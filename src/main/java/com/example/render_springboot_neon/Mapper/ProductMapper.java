package com.example.render_springboot_neon.Mapper;

import com.example.render_springboot_neon.Dto.ProductDto;
import com.example.render_springboot_neon.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto mapToProductDto (Product products){
        return new ProductDto(
                products.getId(),
                products.getName(),
                products.getDescription(),
                products.getPrice()

                );
    }

    public Product mapToProduct (ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }
}
