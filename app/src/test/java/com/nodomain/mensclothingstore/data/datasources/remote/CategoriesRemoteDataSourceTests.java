package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Category;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class CategoriesRemoteDataSourceTests {

    private static final int CATEGORIES_COUNT = 8;
    private static final String FIRST_CATEGORY_NAME = "Футболки и майки";
    private static final String LAST_CATEGORY_NAME = "Белье";

    @Test
    public void getCategories() {
        CategoriesRemoteDataSource categoriesRemoteDataSource = new CategoriesRemoteDataSource();
        List<Category> categories = categoriesRemoteDataSource.getCategories();
        assertEquals(CATEGORIES_COUNT, categories.size());
        assertEquals(categories.get(0).getName(), FIRST_CATEGORY_NAME);
        assertEquals(categories.get(categories.size()-1).getName(), LAST_CATEGORY_NAME);
    }
}
