package com.nodomain.mensclothingstore.domain.events;


public class OnGetCategoryProductsFailureEvent extends BaseFailureEvent {

    public OnGetCategoryProductsFailureEvent(Exception exception) {
        super(exception);
    }
}
