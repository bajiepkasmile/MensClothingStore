package com.nodomain.mensclothingstore.domain.events;


import com.nodomain.mensclothingstore.model.Category;

import java.util.List;


public class OnGetCategoriesSuccessEvent {

    private List<Category> categories;

    public OnGetCategoriesSuccessEvent(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
