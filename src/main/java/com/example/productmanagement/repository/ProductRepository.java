package com.example.productmanagement.repository;

import com.example.productmanagement.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductModel, String> {
}