package com.nodomain.mensclothingstore.ui;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;

import java.util.List;


public class CategoriesNavigationViewAdapter implements NavigationView.OnNavigationItemSelectedListener{

    private List<Category> categories;
    private NavigationView navigationView;
    private OnItemClickListener listener;

    public CategoriesNavigationViewAdapter(List<Category> categories,
                                           NavigationView navigationView,
                                           OnItemClickListener listener) {
        this.categories = categories;
        this.navigationView = navigationView;
        this.listener = listener;

        navigationView.getMenu().clear();
        for (int i = 0; i < categories.size(); i++) {
            navigationView.getMenu().add(0, i, 0, categories.get(i).getName());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        listener.onItemClick(item.getItemId());
        return true;
    }

    public Category getItem(int position) {
        return categories.get(position);
    }
}
