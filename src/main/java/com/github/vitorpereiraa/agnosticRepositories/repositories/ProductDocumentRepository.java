package com.github.vitorpereiraa.agnosticRepositories.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.github.vitorpereiraa.agnosticRepositories.persistence.document.ProductDocumentSchema;

@Profile("documentPersistence")
@Repository
public interface ProductDocumentRepository extends ProductRepository<ProductDocumentSchema, Long>{
}
