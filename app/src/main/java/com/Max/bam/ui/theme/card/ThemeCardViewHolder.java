package com.Max.bam.ui.theme.card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;
import com.Max.bam.ui.theme.RecycleViewClickListener;

public class ThemeCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final TextView themeCardView;
    private final RecycleViewClickListener recycleViewClickListener;

    private ThemeCardViewHolder(@NonNull View itemView, RecycleViewClickListener recycleViewInterface) {
        super(itemView);
        themeCardView = itemView.findViewById(R.id.textView);
        this.recycleViewClickListener = recycleViewInterface;
        itemView.setOnClickListener(this);
    }

    public static ThemeCardViewHolder create(ViewGroup parent, RecycleViewClickListener recycleViewInterface) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ThemeCardViewHolder(view, recycleViewInterface);
    }

    public void bind(String text) {
        themeCardView.setText(text);
    }

    @Override
    public void onClick(View v) {
        recycleViewClickListener.onClick(v, this.getLayoutPosition());
    }
}
