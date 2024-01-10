package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import com.example.paginationsorting.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    public Page<Product> listProducts(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Product> productPage = productRepository.findAll(pageRequest);
        return productPage;
    }
}
