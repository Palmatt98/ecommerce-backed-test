package com.frantoionapoli.controller;

import com.frantoionapoli.model.Product;
import com.frantoionapoli.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product productCreated = productService.saveProduct(product);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getListProduct() {
        List<Product> listProduct = productService.getProducts();
        return new ResponseEntity<>(listProduct, HttpStatus.OK);
    }

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<Product>> getListProductByCategory(@PathVariable Integer categoryId) {
        List<Product> listProduct = productService.getProductsByCategoryId(categoryId);
        return new  ResponseEntity<>(listProduct, HttpStatus.OK);
    }

}
