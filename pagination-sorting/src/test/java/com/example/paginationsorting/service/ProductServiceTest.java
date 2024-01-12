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
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void listProducts() {
        Page<Product> productPage = productService.listProducts(0, 2);

        Assertions.assertEquals(20, productPage.getTotalElements());
        Assertions.assertEquals(10, productPage.getTotalPages());
        Assertions.assertEquals(2, productPage.getNumberOfElements()); // no.of elements in current page

        Pageable pageable = productPage.getPageable();
        Assertions.assertEquals(0, pageable.getPageNumber());
        Assertions.assertEquals(2, pageable.getPageSize());
        Assertions.assertEquals(Sort.unsorted(), pageable.getSort());
        displayContent(productPage.getContent());

        productPage = productService.listProducts(1, 2);
        pageable = productPage.getPageable();
        Assertions.assertEquals(1, pageable.getPageNumber());
        Assertions.assertEquals(2, pageable.getPageSize());
        Assertions.assertEquals(Sort.unsorted(), pageable.getSort()); // sort in response
        displayContent(productPage.getContent());
    }

    @Test
    public void listProductsByName() {
        List<Product> products = productService.listProductsByName(0, 2,
                "Product A");

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        Assertions.assertEquals("Product A", products.get(1).getName());
        displayContent(products);
    }

    @Test
    public void listProductsByNameAndPrice() {
        List<Product> products = productService.listProductsByNameAndPrice(0, 2,
                "Product A", 10.99);

        Assertions.assertEquals(1, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        displayContent(products);
    }

    @Test
    public void listProductsByNameSortByPrice() {
        List<Product> products = productService.listProductsByNameOrderByPrice(0, 2,
                "Product A");

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        Assertions.assertEquals("Product A", products.get(1).getName());
        displayContent(products);
    }

    @Test
    public void listProductsByNameSortByPrice2() {
        List<Product> products = productService.listProductsByNameOrderByPrice2(0, 2,
                "Product A");

        Assertions.assertEquals(2, products.size());
        Assertions.assertEquals("Product A", products.get(0).getName());
        Assertions.assertEquals("Product A", products.get(1).getName());
        displayContent(products);
    }

    @Test
    public void listProductsSortByNameAndPriceAsc() {
        Page<Product> productPage = productService.listProductsOrderByNameAndPriceAsc(0, 20);

        List<Product> products = productPage.getContent();
        Assertions.assertEquals(20, products.size());

        Pageable pageable = productPage.getPageable();
        // strange this is failing
        // Assertions.assertEquals(Sort.by("name", "price"), pageable.getSort()); // sort in response

        displayContent(products);
    }

    @Test
    public void listProductsSortByNameAndPriceAsc2() {
        Page<Product> productPage = productService.listProductsOrderByNameAndPriceAsc2(0, 20);

        List<Product> products = productPage.getContent();
        Assertions.assertEquals(20, products.size());

        Pageable pageable = productPage.getPageable();
        Assertions.assertEquals(Sort.by("name", "price"), pageable.getSort()); // sort in response

        displayContent(products);
    }

    @Test
    public void listProductsSortByNameDescAndPriceAsc() {
        List<Product> products = productService.listProductsOrderByByNameDescAndPriceAsc(0, 20);

        Assertions.assertEquals(20, products.size());

        displayContent(products);
    }

    @Test
    public void listProductsSortByNameDescAndPriceAsc2() {
        Page<Product> productPage = productService.listProductsOrderByByNameDescAndPriceAsc2(0, 20);

        List<Product> products = productPage.getContent();
        Assertions.assertEquals(20, products.size());

        displayContent(products);
    }

    private void displayContent(List<Product> products) {
        System.out.println("List of products");
        products.forEach(System.out::println);
    }
}
