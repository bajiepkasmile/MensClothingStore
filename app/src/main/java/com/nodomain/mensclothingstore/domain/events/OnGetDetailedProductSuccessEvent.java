package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.model.DetailedProduct;


public class OnGetDetailedProductSuccessEvent {

    private DetailedProduct detailedProduct;

    public OnGetDetailedProductSuccessEvent(DetailedProduct detailedProduct) {
        this.detailedProduct = detailedProduct;
    }

    public DetailedProduct getDetailedProduct() {
        return detailedProduct;
    }
}
