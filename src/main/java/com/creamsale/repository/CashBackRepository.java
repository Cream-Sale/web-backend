package com.creamsale.repository;

import com.creamsale.domain.CashBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashBackRepository extends JpaRepository<CashBack, Long> {

    CashBack findCashBackById(Long id);

    CashBack findCashBackName(String name);

}
