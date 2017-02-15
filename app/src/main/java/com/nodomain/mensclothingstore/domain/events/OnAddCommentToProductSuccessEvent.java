package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.model.Comment;


public class OnAddCommentToProductSuccessEvent {

    private Comment comment;

    public OnAddCommentToProductSuccessEvent(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }
}
