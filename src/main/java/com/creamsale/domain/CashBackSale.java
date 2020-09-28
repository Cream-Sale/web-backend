package com.creamsale.domain;

import javax.persistence.*;

@Entity
@Table(name = "cash_back_sale")
public class CashBackSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cashBackId", nullable = false)
    private CashBack cashBack;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "shopId", nullable = false)
    private Shop shop;

    @Column(nullable = false)
    private Float sale;

    @Column(nullable = false)
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

    public Float getSale() {
        return sale;
    }

    public void setSale(Float sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
