package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.domain.Error;


public class OnAddCommentToProductFailureEvent extends BaseFailureEvent {

    public OnAddCommentToProductFailureEvent(Error error) {
        super(error);
    }
}
