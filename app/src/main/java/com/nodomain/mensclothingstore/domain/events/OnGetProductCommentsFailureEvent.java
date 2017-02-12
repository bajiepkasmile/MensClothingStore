package com.nodomain.mensclothingstore.domain.events;


public class OnGetProductCommentsFailureEvent extends BaseFailureEvent {

    public OnGetProductCommentsFailureEvent(Exception exception) {
        super(exception);
    }
}
