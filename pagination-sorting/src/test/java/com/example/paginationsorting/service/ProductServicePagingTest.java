package com.example.paginationsorting.service;

import com.example.paginationsorting.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class ProductServicePagingTest extends AbstractServiceTest {

    @Autowired
    private ProductServicePaging productServicePaging;

    @Test
    public void listProducts() {
        Page<Product> productPage = productServicePaging.listProducts(0, 2);

        Assertions.assertEquals(20, productPage.getTotalElements());
        Assertions.assertEquals(10, productPage.getTotalPages());
        Assertions.assertEquals(2, productPage.getNumberOfElements()); // no.of elements in current page

        Pageable pageable = productPage.getPageable();
        Assertions.assertEquals(0, pageable.getPageNumber());
        Assertions.assertEquals(2, pageable.getPageSize());
        Assertions.assertEquals(Sort.unsorted(), pageable.getSort());
        displayContent(productPage.getContent());

        productPage = productServicePaging.listProducts(1, 2);
        pageable = productPage.getPageable();
        Assertions.assertEquals(1, pageable.getPageNumber());
        Assertions.assertEquals(2, pageable.getPageSize());
        Assertions.assertEquals(Sort.unsorted(), pageable.getSort()); // sort in response
        displayContent(productPage.getContent());
    }

    @Test
    public void listProductsByName() {
        List<Product> products = productServicePaging.listProductsByName(0, 2,
                "Product A");

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        Assertions.assertEquals("Product A", products.get(1).getName());
        displayContent(products);
    }

    @Test
    public void listProductsByNameAndPrice() {
        List<Product> products = productServicePaging.listProductsByNameAndPrice(0, 2,
                "Product A", 10.99);

        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        displayContent(products);
    }

    @Test
    public void listProductsByPriceGreaterThan() {
        Page<Product> productPage = productServicePaging.listProductsByPriceGreaterThan(0, 2,
                20);
        displayContent(productPage.getContent());
    }
}
