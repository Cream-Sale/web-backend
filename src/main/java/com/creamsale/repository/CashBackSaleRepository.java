package com.creamsale.repository;

import com.creamsale.domain.CashBackSale;
import com.creamsale.domain.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashBackSaleRepository extends JpaRepository<CashBackSale, Long> {

    CashBackSale findCashBackSaleById(Long id);

    CashBackSale findCashBackSaleByShop(Shop shop);

}
