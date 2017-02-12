package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.model.Product;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class EventsTests {

    private Exception exception = new Exception();

    @Test
    public void creatingBaseFailureEventIsCorrect() {
        BaseFailureEvent event = new BaseFailureEvent(exception);
        assertEquals(exception, event.getException());
    }

    @Test
    public void creatingOnGetCategoriesFailureEventIsCorrect() {
        OnGetCategoriesFailureEvent event = new OnGetCategoriesFailureEvent(exception);
        assertEquals(exception, event.getException());
    }

    @Test
    public void creatingOnGetCategoriesSuccessEventIsCorrect() {
        List<Category> categories = new ArrayList<>();
        OnGetCategoriesSuccessEvent event = new OnGetCategoriesSuccessEvent(categories);

        assertEquals(categories, event.getCategories());
    }

    @Test
    public void creatingOnGetCategoryProductsFailureEventIsCorrect() {
        OnGetCategoryProductsFailureEvent event = new OnGetCategoryProductsFailureEvent(exception);
        assertEquals(exception, event.getException());
    }

    @Test
    public void creatingOnGetCategoryProductsSuccessEventIsCorrect() {
        List<Product> products = new ArrayList<>();
        OnGetCategoryProductsSuccessEvent event = new OnGetCategoryProductsSuccessEvent(products);

        assertEquals(products, event.getCategoryProducts());
    }
}
