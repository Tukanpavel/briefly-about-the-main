package com.Max.bam.ui.theme.text;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;
import com.Max.bam.ui.theme.RecycleViewClickListener;
import com.Max.bam.ui.theme.random_card.RandomCardViewHolder;

public class ThemeTextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final AppCompatTextView themeTextView;
    private final RecycleViewClickListener recycleViewClickListener;

    private ThemeTextViewHolder(@NonNull View itemView, RecycleViewClickListener recycleViewClickListener) {
        super(itemView);
        themeTextView = (AppCompatTextView) itemView.findViewById(R.id.myTextView);
        themeTextView.setMovementMethod(new ScrollingMovementMethod());
        themeTextView.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        this.recycleViewClickListener = recycleViewClickListener;
        themeTextView.setOnClickListener(this);
    }

    public static ThemeTextViewHolder create(ViewGroup parent, RecycleViewClickListener recycleViewClickListener) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.textview_item, parent, false);
        return new ThemeTextViewHolder(view, recycleViewClickListener);
    }

    public void bind(String text) {
        themeTextView.setText(text);
    }

    @Override
    public void onClick(View v) {
        recycleViewClickListener.onClick(v, this.getLayoutPosition());
    }

}

