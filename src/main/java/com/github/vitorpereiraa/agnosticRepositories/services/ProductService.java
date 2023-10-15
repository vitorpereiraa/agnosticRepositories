package com.github.vitorpereiraa.agnosticRepositories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitorpereiraa.agnosticRepositories.domain.Product;
import com.github.vitorpereiraa.agnosticRepositories.dto.ProductDTO;
import com.github.vitorpereiraa.agnosticRepositories.dto.ProductDTOMapper;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductPersistenceMapper;
import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductSchema;
import com.github.vitorpereiraa.agnosticRepositories.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductDTOMapper productDTOMapper;

    @Autowired
    private ProductPersistenceMapper productPersistenceMapper;

    public Iterable<ProductDTO> getProducts() {

        final Iterable<ProductSchema> productSchemas = productRepository.findAll();

        final Iterable<Product> products = productPersistenceMapper.schemasToProducts(productSchemas);

        return productDTOMapper.productsToDTOs(products);
    }

    public ProductDTO create(final ProductDTO productDTO) {

        final Product product = productDTOMapper.DTOToProduct(productDTO);

        final ProductSchema toPersistence = productPersistenceMapper.productToSchema(product);

        final ProductSchema persistedProductSchema = (ProductSchema) productRepository.save(toPersistence);

        final Product persistedProduct = productPersistenceMapper.schemaToProduct(persistedProductSchema);

        return productDTOMapper.productToDTO(persistedProduct); 
    }
}
