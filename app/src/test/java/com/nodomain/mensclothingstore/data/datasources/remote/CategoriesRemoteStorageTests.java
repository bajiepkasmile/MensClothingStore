package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Category;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class CategoriesRemoteStorageTests {

    private static final int CATEGORIES_COUNT = 8;
    private static final String FIRST_CATEGORY_NAME = "Футболки и майки";
    private static final String LAST_CATEGORY_NAME = "Белье";

    private CategoriesRemoteStorage categoriesRemoteStorage = new CategoriesRemoteStorage();

    @Test
    public void gottenCategoriesAreCorrect() {
        List<Category> categories = categoriesRemoteStorage.getCategories();

        assertEquals(CATEGORIES_COUNT, categories.size());
        assertEquals(categories.get(0).getName(), FIRST_CATEGORY_NAME);
        assertEquals(categories.get(categories.size()-1).getName(), LAST_CATEGORY_NAME);
    }

    @Test
    public void categoriesStorageIsImmutable() {
        categoriesRemoteStorage.getCategories().clear();
        assertEquals(8, categoriesRemoteStorage.getCategories().size());
    }
}
