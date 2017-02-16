package com.nodomain.mensclothingstore.ui.adapters;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.Menu;
import android.view.MenuItem;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.Category;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;

import java.util.List;


public class CategoriesNavigationViewAdapter implements NavigationView.OnNavigationItemSelectedListener{

    private List<Category> categories;
    private OnItemClickListener listener;
    private Menu menu;

    public CategoriesNavigationViewAdapter(List<Category> categories,
                                           NavigationView navigationView,
                                           OnItemClickListener listener) {
        this.categories = categories;
        this.listener = listener;

        menu = navigationView.getMenu();
        menu.clear();
        for (int i = 0; i < categories.size(); i++) {
            menu.add(0, i, i, categories.get(i).getName());
        }
        menu.setGroupCheckable(0, true, true);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        listener.onItemClick(item.getItemId());
        return true;
    }

    public Category getItem(int position) {
        return categories.get(position);
    }

    public void setItemChecked(int position) {
        menu.getItem(position).setChecked(true);
    }

    public void setItemChecked(Category category) {
        int itemIndex = categories.indexOf(category);
        menu.getItem(itemIndex).setChecked(true);
    }
}
