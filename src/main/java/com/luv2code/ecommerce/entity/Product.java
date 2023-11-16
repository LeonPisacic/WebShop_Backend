package com.luv2code.ecommerce.entity;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product") // refers to MySQL table name
@Data // this will automatically create getter/setter methods

public class Product { // class which refers to the each product, not need to specify by in the
                       // shopping cart

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // refers to the column name inside of MySQL table
    private Long id;

    @ManyToOne // many products can have single category
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_Price")
    private BigDecimal unitPrice;

    @Column(name = "image_Url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_In_Stock")
    private Integer unitsInStock;

    @Column(name = "date_Created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_Updated")
    @UpdateTimestamp
    private Date lastUpdated;
}
