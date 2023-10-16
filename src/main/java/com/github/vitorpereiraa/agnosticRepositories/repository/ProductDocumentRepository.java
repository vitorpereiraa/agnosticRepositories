package com.github.vitorpereiraa.agnosticRepositories.repository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.vitorpereiraa.agnosticRepositories.domain.Product;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductDocumentPersistence;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductDocumentSchema;
import com.github.vitorpereiraa.agnosticRepositories.services.ProductRepository;

@Profile("documentPersistence")
@Component
public class ProductDocumentRepository implements ProductRepository {

    @Autowired
    ProductDocumentPersistence productPersistence;

    @Override
    public Iterable<Product> findAll() {
        Iterable<ProductDocumentSchema> productSchemas = productPersistence.findAll();
        return schemasToProducts(productSchemas);
    }

    @Override
    public Product save(Product product) {
        ProductDocumentSchema productSchema = productToSchema(product); 
        ProductDocumentSchema persisted = productPersistence.save(productSchema);
        return schemaToProduct(persisted);
    }

    private ProductDocumentSchema productToSchema(final Product product){
        return new ProductDocumentSchema(product.getSku(), product.getDesignation(), product.getDescription());
    }

    private Product schemaToProduct(final ProductDocumentSchema productSchema){
        return new Product(productSchema.sku, productSchema.designation, productSchema.description);
    }

    private Iterable<Product> schemasToProducts(final Iterable<ProductDocumentSchema> productSchemas){
        return StreamSupport
                .stream(productSchemas.spliterator(),false)
                .map(this::schemaToProduct)
                .collect(Collectors.toList());
    }
}
