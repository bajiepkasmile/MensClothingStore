package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.model.Comment;

import java.util.List;


public class OnGetProductCommentsSuccessEvent {

    private List<Comment> comments;

    public OnGetProductCommentsSuccessEvent(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
