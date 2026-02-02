package com.example.productmanagement.service;

import com.example.productmanagement.model.ProductModel;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {this.repository = repository;}

    public ProductModel addProduct(ProductModel product) {return repository.save(product);}

    public List<ProductModel> getProducts(){
        return repository.findAll();
    }

    public ProductModel getProduct(String id){
        return repository.findById(id).orElse(null);
    }

    public ProductModel updateProduct(String id, ProductModel product){
        ProductModel existingProduct = repository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setAvailable(product.isAvailable());
        return repository.save(existingProduct);
    }

    public void deleteProduct(String id){
        repository.deleteById(id);
    }
}
