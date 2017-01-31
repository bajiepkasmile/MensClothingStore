package com.nodomain.mensclothingstore.domain.events;


public class BaseFailureEvent {

    private Exception exception;

    protected BaseFailureEvent(Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }
}
