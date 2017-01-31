package com.nodomain.mensclothingstore.model;


import org.junit.Test;

import static org.junit.Assert.*;


public class CategoryTests {

    @Test
    public void creatingCategoryIsCorrect() {
        int id = 12;
        String name = "name";
        Category category = new Category(id, name);

        assertEquals(id, category.getId());
        assertEquals(name, category.getName());
    }

    @Test
    public void categoriesWithSameIdAreEquals() {
        Category category1 = new Category(1, "name1");
        Category category2 = new Category(1, "name2");

        assertTrue(category1.equals(category2));
    }

    @Test
    public void categoriesWithDifferentIdAreNotEquals() {
        Category category1 = new Category(1, "name1");
        Category category2 = new Category(2, "name2");

        assertFalse(category1.equals(category2));
    }
}
