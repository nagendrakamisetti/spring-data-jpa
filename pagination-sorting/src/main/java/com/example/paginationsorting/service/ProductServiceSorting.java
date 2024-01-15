package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import com.example.paginationsorting.repo.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceSorting {

    public ProductServiceSorting(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;

    public List<Product> listProductsOrderByPrice() {
        Sort sort = Sort.by("price");
        // Sort sort = Sort.by("price").ascending();
        // Sort sort = Sort.by(Sort.Direction.ASC, "price");
        // Sort sort = Sort.by(Sort.Direction.ASC, "price", "name");
        /*Sort sort = Sort.by("price").ascending()
                .and(Sort.by("name").descending());*/
        List<Product> products = productRepository.findAll(sort);
        return products;
    }

    public List<Product> listProductsOrderByName() {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "name", true,
                Sort.NullHandling.NULLS_FIRST);
        Sort sort = Sort.by(order);
        List<Product> products = productRepository.findAll(sort);
        return products;
    }
}
