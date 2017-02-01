package com.nodomain.mensclothingstore.ui.recyclerviews.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.Product;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;
import com.nodomain.mensclothingstore.ui.recyclerviews.viewholders.ProductViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> products;
    private OnItemClickListener listener;

    public ProductsAdapter(List<Product> products, OnItemClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Context context = holder.ivImage.getContext();
        Product product = products.get(position);
        String formattedPrice = String.format(context.getString(R.string.currency), product.getPrice());

        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(formattedPrice);

        Picasso.with(context)
                .load(product.getImageUrl())
                .into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public Product getItem(int position) {
        return products.get(position);
    }
}
