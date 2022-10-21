package com.Max.bam.ui.theme.random_card;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.Max.bam.ui.theme.RecycleViewClickListener;

public class RandomCardListAdapter extends ListAdapter<String, RandomCardViewHolder> {
    private final RecycleViewClickListener recycleViewClickListener;

    protected RandomCardListAdapter(@NonNull DiffUtil.ItemCallback<String> diffCallback, RecycleViewClickListener recycleViewClickListener) {
        super(diffCallback);
        this.recycleViewClickListener = recycleViewClickListener;
    }

    @NonNull
    @Override
    public RandomCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return RandomCardViewHolder.create(parent, recycleViewClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RandomCardViewHolder holder, int position) {
        String current = getItem(position);
        holder.bind(current);
    }

    public static class RandomCardDiff extends DiffUtil.ItemCallback<String> {

        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return newItem == oldItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }
    }
}
