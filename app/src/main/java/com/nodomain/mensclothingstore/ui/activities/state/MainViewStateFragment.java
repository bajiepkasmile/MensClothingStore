package com.nodomain.mensclothingstore.ui.activities.state;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.nodomain.mensclothingstore.model.Category;

import java.util.List;


public class MainViewStateFragment extends Fragment {

    private List<Category> categories;
    private Category currentCategory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }
}
