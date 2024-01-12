package com.example.paginationsorting.repo;

import com.example.paginationsorting.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // The return can be List or Page
    List<Product> findAllByPrice(double price, Pageable pageable);

    Page<Product> findAllByOrderByNameAscPriceAsc(Pageable pageable);

    List<Product> findAllByOrderByNameDescPriceAsc(Pageable pageable);

}
