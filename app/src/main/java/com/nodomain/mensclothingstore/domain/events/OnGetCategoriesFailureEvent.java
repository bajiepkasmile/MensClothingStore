package com.nodomain.mensclothingstore.domain.events;


public class OnGetCategoriesFailureEvent extends BaseFailureEvent {

    public OnGetCategoriesFailureEvent(Exception exception) {
        super(exception);
    }
}
