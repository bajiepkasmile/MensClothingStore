package com.nodomain.mensclothingstore.data.datasources.remote;


import com.nodomain.mensclothingstore.model.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoriesRemoteDataSource {

    private List<Category> categories;

    public CategoriesRemoteDataSource() {
        categories = new ArrayList<>();
        categories.add(new Category(0, "Футболки и майки"));
        categories.add(new Category(1, "Рубашки"));
        categories.add(new Category(2, "Кардиганы и джемперы"));
        categories.add(new Category(3, "Брюки"));
        categories.add(new Category(4, "Куртки и пальто"));
        categories.add(new Category(5, "Пиджаки и костюмы"));
        categories.add(new Category(6, "Спортивная одежда"));
        categories.add(new Category(7, "Белье"));
    }

    public List<Category> getCategories() {
        return copyCategories(categories);  //return copy to achieve immutability of data source
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
