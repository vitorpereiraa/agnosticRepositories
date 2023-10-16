package com.github.vitorpereiraa.agnosticRepositories.repository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.vitorpereiraa.agnosticRepositories.domain.Product;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductRelationalPersistence;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductRelationalSchema;
import com.github.vitorpereiraa.agnosticRepositories.services.ProductRepository;


@Profile("relationalPersistence")
@Component
public class ProductRelationalRepository implements ProductRepository {

    @Autowired
    ProductRelationalPersistence productPersistence;

    @Override
    public Iterable<Product> findAll() {
        Iterable<ProductRelationalSchema> productSchemas = productPersistence.findAll();
        return schemasToProducts(productSchemas);
    }

    @Override
    public Product save(Product product) {
        ProductRelationalSchema productSchema = productToSchema(product); 
        ProductRelationalSchema persisted = productPersistence.save(productSchema);
        return schemaToProduct(persisted);
    }

    private ProductRelationalSchema productToSchema(final Product product){
        return new ProductRelationalSchema(product.getSku(), product.getDesignation(), product.getDescription());
    }

    private Product schemaToProduct(final ProductRelationalSchema productSchema){
        return new Product(productSchema.sku, productSchema.designation, productSchema.description);
    }

    private Iterable<Product> schemasToProducts(final Iterable<ProductRelationalSchema> productSchemas){
        return StreamSupport
                .stream(productSchemas.spliterator(),false)
                .map(this::schemaToProduct)
                .collect(Collectors.toList());
    }
    
}
