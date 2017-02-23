package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Product;

import org.junit.Test;

import static org.junit.Assert.*;


public class CommentsRemoteStorageTests {

    private CommentsRemoteStorage commentsRemoteStorage = new CommentsRemoteStorage();
    private Product productWithOddId = new Product(1, 0, "", 0, "", "");
    private Product productWithEventId = new Product(2, 0, "", 0, "", "");

    @Test
    public void commentsRemoteStorageIsImmutable() {
        commentsRemoteStorage.getCommentsForProduct(productWithEventId).clear();
        int commentsCount = commentsRemoteStorage.getCommentsForProduct(productWithEventId).size();

        assertTrue(commentsCount > 0);
    }

    @Test
    public void addCommentToProductIsCorrect() {
        commentsRemoteStorage.addCommentToProduct("sender", "text", productWithEventId);
        int commentsCount = commentsRemoteStorage.getCommentsForProduct(productWithEventId).size();

        assertTrue(commentsCount > 0);
    }

    @Test
    public void hasNoCommentsForProductsWithOddId() {
        int commentsCount = commentsRemoteStorage.getCommentsForProduct(productWithOddId).size();
        assertTrue(commentsCount == 0);
    }

    @Test
    public void hasCommentsForProductsWithEvenId() {
        int commentsCount = commentsRemoteStorage.getCommentsForProduct(productWithEventId).size();
        assertTrue(commentsCount > 0);
    }
}
