package com.nodomain.mensclothingstore.ui.recyclerviews.viewholders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_image)
    public ImageView ivImage;
    @BindView(R.id.tv_price)
    public TextView tvPrice;
    @BindView(R.id.tv_name)
    public TextView tvName;

    private OnItemClickListener listener;

    public ProductViewHolder(View itemView, OnItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        listener.onItemClick(getAdapterPosition());
    }
}
