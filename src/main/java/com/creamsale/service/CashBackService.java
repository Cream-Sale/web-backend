package com.creamsale.service;

import com.creamsale.domain.CashBack;
import com.creamsale.exception.NotFoundException;
import com.creamsale.payload.cashback.CashBackRequest;
import com.creamsale.payload.cashback.CashBackResponse;
import com.creamsale.repository.CashBackRepository;
import com.creamsale.service.mapper.CashBackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CashBackService {

    private final CashBackRepository cashBackRepository;

    private final CashBackMapper cashBackMapper;

    @Autowired
    public CashBackService(CashBackRepository cashBackRepository, CashBackMapper cashBackMapper) {
        this.cashBackRepository = cashBackRepository;
        this.cashBackMapper = cashBackMapper;
    }

    public CashBack createCashBack(final CashBackRequest cashBackRequest) {
        CashBack cashBack = cashBackMapper.toCashBackModel(cashBackRequest);
        return cashBackRepository.save(cashBack);
    }

    public List<CashBackResponse> findAllCashBacks() {
        List<CashBack> cashBacks = cashBackRepository.findAll();
        return cashBackMapper.toCashBackResponseList(cashBacks);
    }

    public CashBackResponse findCashBackById(final Long cashBackId) {
        CashBack cashBack = cashBackRepository.findCashBackById(cashBackId);
        if (Objects.isNull(cashBack)) {
            throw new NotFoundException(String.format("CashBack with '%s' id not found", cashBackId));
        }
        return cashBackMapper.toCashBackResponse(cashBack);
    }

    public CashBackResponse findCashBackByName(final String cashBackName) {
        CashBack cashBack = cashBackRepository.findCashBackByName(cashBackName);
        if (Objects.isNull(cashBack)) {
            throw new NotFoundException(String.format("CashBack with '%s' name not found", cashBackName));
        }
        return cashBackMapper.toCashBackResponse(cashBack);
    }

    public boolean existsByCashBackName(final String cashBackName) {
        return cashBackRepository.existsByName(cashBackName);
    }

    public boolean existsByCashBackId(final Long cashBackId) {
        return cashBackRepository.existsById(cashBackId);
    }

}
