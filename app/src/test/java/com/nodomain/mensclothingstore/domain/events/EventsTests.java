package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.domain.Error;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.model.Product;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;


public class EventsTests {

    private Error error = Error.EMPTY_FIELD;

    @Test
    public void creatingBaseFailureEventIsCorrect() {
        BaseFailureEvent event = new BaseFailureEvent(error);
        assertEquals(error, event.getError());
    }

    @Test
    public void creatingOnAddCommentToProductFailureEventIsCorrect() {
        OnAddCommentToProductFailureEvent event = new OnAddCommentToProductFailureEvent(error);
        assertEquals(error, event.getError());
    }

    @Test
    public void creatingOnAddCommentToProductSuccessEventIsCorrect() {
        Comment comment = new Comment("sender", Calendar.getInstance(), "text");
        OnAddCommentToProductSuccessEvent event = new OnAddCommentToProductSuccessEvent(comment);

        assertEquals(comment, event.getComment());
    }

    @Test
    public void creatingOnGetCategoriesFailureEventIsCorrect() {
        OnGetCategoriesFailureEvent event = new OnGetCategoriesFailureEvent(error);
        assertEquals(error, event.getError());
    }

    @Test
    public void creatingOnGetCategoriesSuccessEventIsCorrect() {
        List<Category> categories = new ArrayList<>();
        OnGetCategoriesSuccessEvent event = new OnGetCategoriesSuccessEvent(categories);

        assertEquals(categories, event.getCategories());
    }

    @Test
    public void creatingOnGetCategoryProductsFailureEventIsCorrect() {
        OnGetCategoryProductsFailureEvent event = new OnGetCategoryProductsFailureEvent(error);
        assertEquals(error, event.getError());
    }

    @Test
    public void creatingOnGetCategoryProductsSuccessEventIsCorrect() {
        List<Product> products = new ArrayList<>();
        OnGetCategoryProductsSuccessEvent event = new OnGetCategoryProductsSuccessEvent(products);

        assertEquals(products, event.getCategoryProducts());
    }

    @Test
    public void creatingOnGetProductCommentsFailureEventIsCorrect() {
        OnGetProductCommentsFailureEvent event = new OnGetProductCommentsFailureEvent(error);
        assertEquals(error, event.getError());
    }

    @Test
    public void creatingOnGetProductCommentsSuccessEventIsCorrect() {
        List<Comment> comments = new ArrayList<>();
        OnGetProductCommentsSuccessEvent event = new OnGetProductCommentsSuccessEvent(comments);

        assertEquals(comments, event.getComments());
    }
}
