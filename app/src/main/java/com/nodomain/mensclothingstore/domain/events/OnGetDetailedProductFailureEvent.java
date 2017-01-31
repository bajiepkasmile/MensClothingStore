package com.nodomain.mensclothingstore.domain.events;


public class OnGetDetailedProductFailureEvent extends BaseFailureEvent {

    public OnGetDetailedProductFailureEvent(Exception exception) {
        super(exception);
    }
}
