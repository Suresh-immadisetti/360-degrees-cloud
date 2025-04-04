package com.example.productmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Transactional
    public Product addProduct(Product product) {
        product.setId(null); // Ensure it's treated as a new record
        return productRepository.save(product);
    }

	@Override
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product existingProduct = getProductById(id);
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		return productRepository.save(existingProduct);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
