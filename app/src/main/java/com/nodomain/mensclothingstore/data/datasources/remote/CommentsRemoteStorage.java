package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;


public class CommentsRemoteStorage {

    private List<Comment> comments;
    private Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Moscow"));

    public CommentsRemoteStorage() {
        calendar.setTimeInMillis(1386230874 * 1000L);

        comments = new ArrayList<>();
        comments.add(new Comment("Alex", calendar, "asd1"));
        comments.add(new Comment("Bob", calendar, "aaasssddd"));
        comments.add(new Comment("Oscar", calendar, "3asdasdasd3"));
        comments.add(new Comment("Carl", calendar, "123asdasd"));
    }

    public List<Comment> getCommentsForProduct(Product product) {
        if (product.getId() % 2 == 0) {
            return copyComments(comments); //return copy to achieve immutability of storage
        } else {
            return Collections.emptyList();
        }
    }

    public Comment addCommentToProduct(String senderName, String text, Product product) {
        Comment comment = new Comment(senderName, calendar, text);
        comments.add(comment);
        return comment;
    }

    private List<Comment> copyComments(List<Comment> comments) {
        List<Comment> copiedComments = new ArrayList<>();
        for (Comment comment : comments) {
            Comment copiedComment = new Comment(comment.getSenderName(), comment.getSentTime(), comment.getText());
            copiedComments.add(copiedComment);
        }
        return copiedComments;
    }
}
