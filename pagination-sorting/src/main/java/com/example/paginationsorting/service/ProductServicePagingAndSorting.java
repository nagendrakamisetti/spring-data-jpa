package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import com.example.paginationsorting.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServicePagingAndSorting {

    public ProductServicePagingAndSorting(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    public List<Product> listProductsByNameOrderByPrice(int pageNumber, int pageSize, String name) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        List<Product> products = productRepository.findAllByNameOrderByPrice(name, pageRequest);
        return products;
    }

    public List<Product> listProductsByNameOrderByPrice2(int pageNumber, int pageSize, String name) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("price").ascending());
        List<Product> products = productRepository.findAllByName(name, pageRequest);
        return products;
    }

    public Page<Product> listProductsOrderByNameAndPriceAsc(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productRepository.findAllByOrderByNameAscPriceAsc(pageRequest);
    }

    public Page<Product> listProductsOrderByNameAndPriceAsc2(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("name", "price").ascending());
        return productRepository.findAll(pageRequest);
    }

    public List<Product> listProductsOrderByByNameDescAndPriceAsc(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productRepository.findAllByOrderByNameDescPriceAsc(pageRequest);
    }

    public Page<Product> listProductsOrderByByNameDescAndPriceAsc2(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size,
                Sort.by("name").descending()
                        .and(Sort.by("price").ascending()));
        return productRepository.findAll(pageRequest);
    }
}
