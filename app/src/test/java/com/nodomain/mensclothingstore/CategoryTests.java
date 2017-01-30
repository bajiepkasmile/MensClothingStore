package com.nodomain.mensclothingstore;


import org.junit.Test;

import static org.junit.Assert.*;


public class CategoryTests {

    @Test
    public void creatingCategory() {
        int id = 12;
        String name = "name";

        Category category = new Category(id, name);

        assertEquals(id, category.getId());
        assertEquals(name, category.getName());
    }
}
