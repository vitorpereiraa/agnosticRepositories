package com.github.vitorpereiraa.agnosticRepositories.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("documentPersistence")
@Repository
public interface ProductDocumentPersistence extends MongoRepository<ProductDocumentSchema, Long>{
}
