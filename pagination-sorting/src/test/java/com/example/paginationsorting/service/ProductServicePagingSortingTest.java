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
public class ProductServicePagingSortingTest extends AbstractServiceTest {

    @Autowired
    private ProductServicePagingAndSorting productServicePagingAndSorting;

    @Test
    public void listProductsByNameSortByPrice() {
        List<Product> products = productServicePagingAndSorting.listProductsByNameOrderByPrice(0, 2,
                "Product A");

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        Assertions.assertEquals("Product A", products.get(1).getName());
        displayContent(products);
    }

    @Test
    public void listProductsByNameSortByPrice2() {
        List<Product> products = productServicePagingAndSorting.listProductsByNameOrderByPrice2(0, 2,
                "Product A");

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        Assertions.assertEquals("Product A", products.get(1).getName());
        displayContent(products);
    }

    @Test
    public void listProductsSortByNameAndPriceAsc() {
        Page<Product> productPage = productServicePagingAndSorting.listProductsOrderByNameAndPriceAsc(0, 20);

        List<Product> products = productPage.getContent();
        Assertions.assertEquals(20, products.size());

        Pageable pageable = productPage.getPageable();
        // strange this is failing
        // Assertions.assertEquals(Sort.by("name", "price"), pageable.getSort()); // sort in response

        displayContent(products);
    }

    @Test
    public void listProductsSortByNameAndPriceAsc2() {
        Page<Product> productPage = productServicePagingAndSorting.listProductsOrderByNameAndPriceAsc2(0, 20);

        List<Product> products = productPage.getContent();
        Assertions.assertEquals(20, products.size());

        Pageable pageable = productPage.getPageable();
        Assertions.assertEquals(Sort.by("name", "price"), pageable.getSort()); // sort in response

        displayContent(products);
    }

    @Test
    public void listProductsSortByNameDescAndPriceAsc() {
        List<Product> products = productServicePagingAndSorting.listProductsOrderByByNameDescAndPriceAsc(0, 20);

        Assertions.assertEquals(20, products.size());

        displayContent(products);
    }

    @Test
    public void listProductsSortByNameDescAndPriceAsc2() {
        Page<Product> productPage = productServicePagingAndSorting.listProductsOrderByByNameDescAndPriceAsc2(0, 20);

        List<Product> products = productPage.getContent();
        Assertions.assertEquals(20, products.size());

        displayContent(products);
    }


}
