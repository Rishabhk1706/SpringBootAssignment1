package com.example.productmanagement.controller;

import com.example.productmanagement.model.ProductModel;
import com.example.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;
    public ProductController(ProductService service){this.service = service;}

    @GetMapping("/")
    public String greet(){
        return "working";
    }

    @PostMapping("/add-product")
    public ProductModel addProduct(@Valid @RequestBody ProductModel product){
        return service.addProduct(product);
    }

    @GetMapping("/products")
    public List<ProductModel> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public ProductModel getProduct(@PathVariable String id){
        return service.getProduct(id);
    }

    @PutMapping("/update/{id}")
    public ProductModel updateProduct(@PathVariable String id, @RequestBody ProductModel product){
        return service.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id){
        service.deleteProduct(id);
    }
}