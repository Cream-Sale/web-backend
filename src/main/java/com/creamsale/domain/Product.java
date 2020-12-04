package com.creamsale.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String name;

    @Column
    @Size(max = 255)
    private String fullName;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    @Max(Long.MAX_VALUE)
    private Long shopId;

    @Column(nullable = false)
    @NotNull
    @DecimalMin("0.1")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private Currency currency;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 255)
    private String shopCategory;

    @Column(nullable = false)
    @NotBlank
    private String imageLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
