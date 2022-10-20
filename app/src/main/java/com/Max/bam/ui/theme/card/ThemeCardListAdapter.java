package com.Max.bam.ui.theme.card;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.Max.bam.data.entity.ThemeCard;
import com.Max.bam.ui.theme.RecycleViewClickListener;

public class ThemeCardListAdapter extends ListAdapter<ThemeCard, ThemeCardViewHolder> {
    private final RecycleViewClickListener recycleViewClickListener;

    public ThemeCardListAdapter(@NonNull DiffUtil.ItemCallback<ThemeCard> diffCallback, RecycleViewClickListener recycleViewClickListener) {
        super(diffCallback);
        this.recycleViewClickListener = recycleViewClickListener;
    }

    @NonNull
    @Override
    public ThemeCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ThemeCardViewHolder.create(parent, recycleViewClickListener);
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
