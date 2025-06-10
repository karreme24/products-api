package com.example.render_springboot_neon.controllers;

import com.example.render_springboot_neon.Dto.ProductDto;
import com.example.render_springboot_neon.services.ProductService;
import com.example.render_springboot_neon.services.imp.ProductServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {
private ProductService productService;



    // Create Product Endpoint
        @PostMapping
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductDto productDto){
        ProductDto saveProduct = productService.createProduct(productDto);
        return ResponseEntity.ok(saveProduct);
    }

    //Delete product Endpoint
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteProduct (@PathVariable("id") Long productId){

            productService.deleteProduct(productId);
            return ResponseEntity.ok("delete product: "+ productId + "success");
    }

    // Get By id endpoint
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId){
            ProductDto productDto = productService.getProduct(productId);
            return  ResponseEntity.ok(productDto);
    }

    // Get all endpoint
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts (){
            List<ProductDto> allProducts = productService.getAllProducts();
            return ResponseEntity.ok(allProducts);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId, @RequestBody  ProductDto updateProductDto){
            ProductDto productDto = productService.updateProduct(productId,updateProductDto);
            return ResponseEntity.ok(productDto);

    }




}
