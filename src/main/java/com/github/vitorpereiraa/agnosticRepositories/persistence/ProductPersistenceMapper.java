package com.github.vitorpereiraa.agnosticRepositories.persistence;

import com.github.vitorpereiraa.agnosticRepositories.domain.Product;

public interface ProductPersistenceMapper {

    ProductSchema productToSchema(final Product product);

    Product schemaToProduct(final ProductSchema productSchema);

    Iterable<Product> schemasToProducts(final Iterable<ProductSchema> productSchemas);
}

