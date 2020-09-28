package com.creamsale.service;

import com.creamsale.domain.CashBack;
import com.creamsale.payload.cashback.CashBackRequest;
import com.creamsale.payload.cashback.CashBackResponse;
import com.creamsale.repository.CashBackRepository;
import com.creamsale.service.mapper.CashBackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return cashBackMapper.toCashBackResponse(cashBack);
    }

    public CashBackResponse findCashBackByName(final String cashBackName) {
        CashBack cashBack = cashBackRepository.findCashBackByName(cashBackName);
        return cashBackMapper.toCashBackResponse(cashBack);
    }

}
