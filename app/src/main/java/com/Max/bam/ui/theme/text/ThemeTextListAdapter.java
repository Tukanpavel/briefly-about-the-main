package com.Max.bam.ui.theme.text;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.Max.bam.data.entity.ThemeCard;

public class ThemeTextListAdapter extends ListAdapter<ThemeCard, ThemeTextViewHolder> {
    public ThemeTextListAdapter(@NonNull DiffUtil.ItemCallback<ThemeCard> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ThemeTextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ThemeTextViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeTextViewHolder holder, int position) {
        ThemeCard current = getItem(position);
        holder.bind(current.text);
    }

    public static class ThemeTextDiff extends DiffUtil.ItemCallback<ThemeCard> {

        @Override
        public boolean areItemsTheSame(@NonNull ThemeCard oldItem, @NonNull ThemeCard newItem) {
            return newItem == oldItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ThemeCard oldItem, @NonNull ThemeCard newItem) {
            return oldItem.text.equals(newItem.text);
        }
    }
}
