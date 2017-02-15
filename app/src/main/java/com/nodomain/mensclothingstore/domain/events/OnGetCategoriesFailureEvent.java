package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.domain.Error;


public class OnGetCategoriesFailureEvent extends BaseFailureEvent {

    public OnGetCategoriesFailureEvent(Error error) {
        super(error);
    }
}
