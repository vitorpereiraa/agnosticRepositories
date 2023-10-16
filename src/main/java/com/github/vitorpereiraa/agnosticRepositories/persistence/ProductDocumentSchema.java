package com.github.vitorpereiraa.agnosticRepositories.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;

@Profile("documentPersistence")
@Document
public class ProductDocumentSchema {

    @Id
    public Long productID;

    @Indexed(unique = true)
    public String sku;

    @Field
    public String designation;

    @Field
    public String description;

    protected ProductDocumentSchema(){}

    public ProductDocumentSchema(String sku, String designation, String description){
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }
}
