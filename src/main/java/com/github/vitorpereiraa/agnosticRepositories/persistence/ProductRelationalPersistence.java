package com.github.vitorpereiraa.agnosticRepositories.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Profile("relationalPersistence")
@Repository
public interface ProductRelationalPersistence extends JpaRepository<ProductRelationalSchema, Long> {
}
