package com.github.vitorpereiraa.agnosticRepositories.persistence.relational;

import com.github.vitorpereiraa.agnosticRepositories.persistence.ProductSchema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name="Product")
public class ProductRelationalSchema implements ProductSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productID;

    @Column(nullable = false, unique = true)
    public String sku;

    @Column(nullable = false)
    private String designation;

    @Column(nullable = false)
    private String description;

    protected ProductRelationalSchema(){}

    public ProductRelationalSchema(String sku, String designation, String description){
        this.sku = sku;
        this.designation = designation;
        this.description = description;
    }
}
