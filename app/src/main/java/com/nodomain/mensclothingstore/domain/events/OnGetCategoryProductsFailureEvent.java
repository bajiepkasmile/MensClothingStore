package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.domain.Error;


public class OnGetCategoryProductsFailureEvent extends BaseFailureEvent {

    public OnGetCategoryProductsFailureEvent(Error error) {
        super(error);
    }
}
