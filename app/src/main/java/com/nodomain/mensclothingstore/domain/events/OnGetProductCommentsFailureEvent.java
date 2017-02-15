package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.domain.Error;


public class OnGetProductCommentsFailureEvent extends BaseFailureEvent {

    public OnGetProductCommentsFailureEvent(Error error) {
        super(error);
    }
}
