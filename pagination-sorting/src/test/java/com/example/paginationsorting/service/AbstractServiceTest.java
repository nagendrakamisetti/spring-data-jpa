package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;

import java.util.List;

public abstract class AbstractServiceTest {

    void displayContent(List<Product> products) {
        System.out.println("List of products");
        products.forEach(System.out::println);
    }
}
