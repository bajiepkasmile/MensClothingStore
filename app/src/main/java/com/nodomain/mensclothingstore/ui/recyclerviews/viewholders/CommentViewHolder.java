package com.nodomain.mensclothingstore.ui.recyclerviews.viewholders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nodomain.mensclothingstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CommentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    public TextView tvName;
    @BindView(R.id.tv_time)
    public TextView tvTime;
    @BindView(R.id.tv_text)
    public TextView tvText;

    public CommentViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
