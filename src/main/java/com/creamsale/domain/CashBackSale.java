package com.creamsale.domain;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "cash_back_sale")
public class CashBackSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cashBackId", nullable = false)
    @NotNull
    private CashBack cashBack;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shopId", nullable = false)
    @NotNull
    private Shop shop;

    @Column(nullable = false)
    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("100.00")
    private BigDecimal sale;

    @Column(nullable = false)
    @NotBlank
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CashBack getCashBack() {
        return cashBack;
    }

    public void setCashBack(CashBack cashBack) {
        this.cashBack = cashBack;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
