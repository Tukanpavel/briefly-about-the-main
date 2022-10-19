package com.Max.bam.ui.theme_card;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;

public class ThemeCardViewHolder extends RecyclerView.ViewHolder {
    private final TextView themeCardView;

    private ThemeCardViewHolder(@NonNull View itemView) {
        super(itemView);
        themeCardView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text){
        themeCardView.setText(text);
    }

    public static ThemeCardViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ThemeCardViewHolder(view);
    }
}
