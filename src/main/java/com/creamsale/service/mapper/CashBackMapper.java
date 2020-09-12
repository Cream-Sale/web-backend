package com.creamsale.service.mapper;

import com.creamsale.domain.CashBack;
import com.creamsale.payload.cashback.CashBackRequest;
import com.creamsale.payload.cashback.CashBackResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CashBackMapper {

    public CashBack toCashBackModel(final CashBackRequest cashBackRequest) {
        if (Objects.isNull(cashBackRequest)) {
            return null;
        }
        CashBack cashBack = new CashBack();
        cashBack.setName(cashBackRequest.getName());
        cashBack.setLink(cashBackRequest.getLink());
        cashBack.setImgLink(cashBackRequest.getImgLink());
        return cashBack;
    }

    public CashBackResponse toCashBackResponse(final CashBack cashBack) {
        if (Objects.isNull(cashBack)) {
            return null;
        }
        return new CashBackResponse(cashBack.getId(), cashBack.getName(), cashBack.getLink(), cashBack.getImgLink());
    }

    public List<CashBackResponse> toCashBackResponseList(final List<CashBack> cashBacks) {
        return cashBacks.stream()
                .filter(Objects::nonNull)
                .map(this::toCashBackResponse)
                .collect(Collectors.toList());
    }

}
