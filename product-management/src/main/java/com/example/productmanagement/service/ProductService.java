package com.example.productmanagement.service;
import java.util.List;

import com.example.productmanagement.entity.Product;

public interface ProductService {
    Product addProduct(Product product);
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
}