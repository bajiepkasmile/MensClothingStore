package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.domain.Error;


public class BaseFailureEvent {

    private Error error;

    public BaseFailureEvent(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
}
