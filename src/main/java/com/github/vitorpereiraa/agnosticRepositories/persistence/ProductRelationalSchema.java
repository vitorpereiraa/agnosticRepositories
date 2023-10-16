package com.github.vitorpereiraa.agnosticRepositories.persistence;

import org.springframework.context.annotation.Profile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Profile("relationalPersistence")
@Entity
@Table(name="Product")
public class ProductRelationalSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long productID;

    @Column(nullable = false, unique = true)
    public String sku;

    @Column(nullable = false)
    public String designation;

    @Column(nullable = false)
    public String description;

    protected ProductRelationalSchema(){}

    public ProductRelationalSchema(String sku, String designation, String description){
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }
}
