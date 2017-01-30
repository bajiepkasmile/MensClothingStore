package com.nodomain.mensclothingstore.data.datasources.cache;


import com.nodomain.mensclothingstore.model.Category;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CategoriesCacheTests {

    @Test
    public void categoriesCacheIsEmptyWhenCreated() {
        CategoriesCache categoriesCache = new CategoriesCache();
        assertFalse(categoriesCache.isEmpty());
    }

    @Test
    public void categoriesCacheIsNotEmptyAfterSetting() {
        CategoriesCache categoriesCache = new CategoriesCache();
        categoriesCache.setCategories(new ArrayList<Category>());
        assertTrue(categoriesCache.isEmpty());
    }

    @Test
    public void categoriesCacheIsImmutable() {
        CategoriesCache categoriesCache = new CategoriesCache();
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "0"));
        categories.add(new Category(1, "1"));
        categories.add(new Category(2, "2"));
        categoriesCache.setCategories(categories);

        categories.remove(0);
        categoriesCache.getCategoriesCopy().remove(0);

        assertEquals(3, categoriesCache.getCategoriesCopy().size());
    }

    @Test
    public void getCachedCategoriesCopy() {
        CategoriesCache categoriesCache = new CategoriesCache();
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "0"));
        categories.add(new Category(1, "1"));
        categories.add(new Category(2, "2"));
        categoriesCache.setCategories(categories);

        assertEquals(3, categoriesCache.getCategoriesCopy().size());
        assertEquals("0", categoriesCache.getCategoriesCopy().get(0).getName());
        assertEquals("1", categoriesCache.getCategoriesCopy().get(1).getName());
        assertEquals("2", categoriesCache.getCategoriesCopy().get(2).getName());
    }
}
