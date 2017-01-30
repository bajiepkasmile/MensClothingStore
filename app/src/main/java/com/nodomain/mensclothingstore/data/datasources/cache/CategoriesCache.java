package com.nodomain.mensclothingstore.data.datasources.cache;


import com.nodomain.mensclothingstore.model.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CategoriesCache {

    private List<Category> cachedCategories;

    public boolean isEmpty() {
        return cachedCategories != null;
    }

    public void setCategories(List<Category> categories) {
        cachedCategories = copyCategories(categories);  //save copy to achieve immutability of cache
    }

    public List<Category> getCategoriesCopy() {
        if (isEmpty())
            return copyCategories(cachedCategories);    //return copy to achieve immutability of cache
        else
            return Collections.emptyList();
    }

    private List<Category> copyCategories(List<Category> categories) {
        List<Category> copiedCategories = new ArrayList<>();
        for (Category category : categories) {
            Category copiedCategory = new Category(category.getId(), category.getName());
            copiedCategories.add(copiedCategory);
        }
        return copiedCategories;
    }
}
