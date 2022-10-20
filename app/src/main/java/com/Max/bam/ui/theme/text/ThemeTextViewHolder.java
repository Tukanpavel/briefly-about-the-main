package com.Max.bam.ui.theme.text;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;

public class ThemeTextViewHolder extends RecyclerView.ViewHolder {
    private final TextView themeTextView;

    private ThemeTextViewHolder(@NonNull View itemView) {
        super(itemView);
        themeTextView = itemView.findViewById(R.id.textView);
    }

    public static ThemeTextViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ThemeTextViewHolder(view);
    }

    public void bind(String text) {
        themeTextView.setText(text);
    }
}

