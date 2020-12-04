package com.creamsale.service;

import com.creamsale.payload.cashback.CashBackSaleResponse;
import com.creamsale.payload.product.ProductOffer;
import com.creamsale.payload.product.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final ProductService productService;

    private final CashBackSaleService cashBackSaleService;

    @Autowired
    public SearchService(ProductService productService, CashBackSaleService cashBackSaleService) {
        this.productService = productService;
        this.cashBackSaleService = cashBackSaleService;
    }

    public List<ProductOffer> findProductOffersByPartOfProductName(final String partOfProductName) {
        List<ProductResponse> productResponses = productService.findProductsByPartOfName(partOfProductName);
        return getProductOffers(productResponses);
    }

    public List<ProductOffer> findProductOffersByPartOfProductNameAndShopsAndPriceRange(
            final String partOfProductName,
            final List<Long> shops,
            final Float priceFrom,
            final Float priceTo) {

        List<ProductResponse> productResponses = productService.findProductsByPartOfNameAndShopsAndPriceRange(
                partOfProductName, shops, priceFrom, priceTo
        );
        return getProductOffers(productResponses);
    }

    private List<ProductOffer> getProductOffers(List<ProductResponse> productResponses) {
        List<ProductOffer> productOfferResponses = productResponses.stream()
                .filter(Objects::nonNull)
                .map(productResponse -> {
                    CashBackSaleResponse cashBackSaleResponse = cashBackSaleService.findCashBackSaleByShopId(productResponse.getShopId());
                    String priceWithSale = String.valueOf(
                            (100 - cashBackSaleResponse.getSale().floatValue()) * productResponse.getPrice().floatValue() / 100
                    );
                    return new ProductOffer(
                            productResponse.getName(),
                            productResponse.getImageLink(),
                            String.valueOf(productResponse.getPrice()),
                            priceWithSale,
                            cashBackSaleResponse.getCashBack().getImgLink()
                    );
                })
                .collect(Collectors.toList());
        return productOfferResponses;
    }
}
