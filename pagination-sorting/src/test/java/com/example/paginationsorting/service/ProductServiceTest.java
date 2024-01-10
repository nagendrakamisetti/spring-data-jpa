package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testListProducts() {
        Page<Product> productPage = productService.listProducts(0, 2);

        Assertions.assertEquals(20, productPage.getTotalElements());
        Assertions.assertEquals(10, productPage.getTotalPages());
        Assertions.assertEquals(2, productPage.getNumberOfElements()); // no.of elements in current page

        Pageable pageable = productPage.getPageable();
        Assertions.assertEquals(0, pageable.getPageNumber());
        Assertions.assertEquals(2, pageable.getPageSize());
        Assertions.assertEquals(Sort.unsorted(), pageable.getSort());

        productPage = productService.listProducts(1, 2);
        pageable = productPage.getPageable();
        Assertions.assertEquals(1, pageable.getPageNumber());
        Assertions.assertEquals(2, pageable.getPageSize());
        Assertions.assertEquals(Sort.unsorted(), pageable.getSort());
    }


}
