package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import com.example.paginationsorting.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Product> listProductsByPrice(int pageNumber, int pageSize, double price) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        List<Product> products = productRepository.findAllByPrice(price, pageRequest);
        return products;
    }

    public Page<Product> listProductsSortByNameAndPriceAsc(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name", "price").ascending());
        return productRepository.findAllByOrderByNameAscPriceAsc(pageRequest);
    }

    public List<Product> listProductsSortByNameDescAndPriceAsc(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size,
                Sort.by("name").descending()
                        .and(Sort.by("price").ascending()));
        return productRepository.findAllByOrderByNameDescPriceAsc(pageRequest);
    }


}
