package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CommentsRemoteStorage {

    private List<Comment> comments;

    public CommentsRemoteStorage() {
        comments = new ArrayList<>();
        comments.add(new Comment("Alex", 41323351, "asd1"));
        comments.add(new Comment("Bob", 2341251, "aaasssddd"));
        comments.add(new Comment("Oscar", 415512521, "3asdasdasd3"));
        comments.add(new Comment("Carl", 412251, "123asdasd"));
    }

    public List<Comment> getCommentsForProduct(Product product) {
        if (product.getId() % 2 == 0) {
            return comments;
        } else {
            return Collections.emptyList();
        }
    }

    public Comment addCommentToProduct(String senderName, String text, Product product) {
        Comment comment = new Comment(senderName, 5232234, text);
        comments.add(comment);
        return comment;
    }
}
