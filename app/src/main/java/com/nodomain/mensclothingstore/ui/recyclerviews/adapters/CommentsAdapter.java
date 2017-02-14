package com.nodomain.mensclothingstore.ui.recyclerviews.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nodomain.mensclothingstore.R;
import com.nodomain.mensclothingstore.model.Comment;
import com.nodomain.mensclothingstore.ui.listeners.OnItemClickListener;
import com.nodomain.mensclothingstore.ui.recyclerviews.viewholders.CommentViewHolder;

import java.util.List;


public class CommentsAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private List<Comment> comments;

    public CommentsAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment comment = comments.get(position);

        holder.tvName.setText(comment.getSenderName());
        holder.tvTime.setText(comment.getSentTime() + "");
        holder.tvText.setText(comment.getText());

        if (position == getItemCount() - 1) {
            holder.divider.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
