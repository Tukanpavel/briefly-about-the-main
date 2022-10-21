package com.Max.bam.ui.theme.random_card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;
import com.Max.bam.ui.theme.RecycleViewClickListener;

public class RandomCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView randomCardTextView;
    private final RecycleViewClickListener recycleViewClickListener;


    private RandomCardViewHolder(@NonNull View itemView, RecycleViewClickListener recycleViewClickListener) {
        super(itemView);
        randomCardTextView = itemView.findViewById(R.id.textView);
        this.recycleViewClickListener = recycleViewClickListener;
        itemView.setOnClickListener(this);
    }

    public static RandomCardViewHolder create(ViewGroup parent, RecycleViewClickListener recycleViewClickListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new RandomCardViewHolder(view, recycleViewClickListener);
    }

    public void bind(String text) {
        randomCardTextView.setText(text);
    }

    @Override
    public void onClick(View v) {
        recycleViewClickListener.onClick(v, this.getLayoutPosition());
    }
}
