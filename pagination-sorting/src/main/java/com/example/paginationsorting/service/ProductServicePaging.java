package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import com.example.paginationsorting.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicePaging {

    public ProductServicePaging(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    public Page<Product> listProducts(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageRequest);
    }

    public List<Product> listProductsByName(int pageNumber, int pageSize, String name) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAllByName(name, pageRequest);
    }

    public List<Product> listProductsByNameAndPrice(int pageNumber, int pageSize, String name, double price) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAllByNameAndPrice(name, price, pageRequest);
    }

    public Page<Product> listProductsByPriceGreaterThan(int pageNumber, int pageSize, double price) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findByPriceGreaterThan(price, pageRequest);
    }
}
