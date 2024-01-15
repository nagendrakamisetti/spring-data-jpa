package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceSortingTest extends AbstractServiceTest {

    @Autowired
    private ProductServiceSorting productServiceSorting;

    @Test
    public void listProductsOrderByPrice() {
        List<Product> products = productServiceSorting.listProductsOrderByPrice();
        displayContent(products);
    }

    @Test
    public void listProductsOrderByName() {
        List<Product> products = productServiceSorting.listProductsOrderByName();
        displayContent(products);
    }
}
