package com.github.vitorpereiraa.agnosticRepositories.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.github.vitorpereiraa.agnosticRepositories.persistence.relational.ProductRelationalSchema;

@Profile("relationalPersistence")
@Repository
public interface ProductRelationalRepository extends ProductRepository<ProductRelationalSchema, Long> {
}
