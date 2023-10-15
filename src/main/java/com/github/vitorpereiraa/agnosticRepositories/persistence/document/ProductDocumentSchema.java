package com.github.vitorpereiraa.agnosticRepositories.persistence.document;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductSchema;

import jakarta.persistence.Id;
import lombok.Getter;

@Document
@Getter
public class ProductDocumentSchema implements ProductSchema {

    @Id
    private Long productID;

    @Indexed(unique = true)
    private String sku;

    @Field
    private String designation;

    @Field
    private String description;

    protected ProductDocumentSchema(){}

    public ProductDocumentSchema(String sku, String designation, String description){
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }
}
