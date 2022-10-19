package com.Max.bam.ui.theme_card;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.Max.bam.data.entity.ThemeCard;

public class ThemeCardListAdapter extends ListAdapter<ThemeCard, ThemeCardViewHolder> {

    public ThemeCardListAdapter(@NonNull DiffUtil.ItemCallback<ThemeCard> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ThemeCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ThemeCardViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeCardViewHolder holder, int position) {
        ThemeCard current = getItem(position);
        holder.bind(current.themeName);
    }

    public static class ThemeCardDiff extends DiffUtil.ItemCallback<ThemeCard> {

        @Override
        public boolean areItemsTheSame(@NonNull ThemeCard oldItem, @NonNull ThemeCard newItem) {
            return newItem == oldItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ThemeCard oldItem, @NonNull ThemeCard newItem) {
            return oldItem.themeName.equals(newItem.themeName);
        }
    }
}
