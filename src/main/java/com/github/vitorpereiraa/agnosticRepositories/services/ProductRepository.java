package com.github.vitorpereiraa.agnosticRepositories.services;

import org.springframework.stereotype.Component;

import com.github.vitorpereiraa.agnosticRepositories.domain.Product;

@Component
public interface ProductRepository {

    Iterable<Product> findAll();
    Product save(Product product);
}
