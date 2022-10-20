package com.Max.bam.ui.theme.random_card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;
import com.Max.bam.ui.theme.ThemeViewModel;

public class RandomCardFragment extends Fragment {
    private ThemeViewModel mViewModel;

    public static RandomCardFragment newInstance() {
        return new RandomCardFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final RandomCardListAdapter randomCardListAdapter = new RandomCardListAdapter(
                new RandomCardListAdapter.RandomCardDiff(), (v, position) -> {
            LinearLayout linearLayout = (LinearLayout) v;
            AppCompatTextView textView = (AppCompatTextView) linearLayout.getChildAt(0);
            String theme = textView.getText().toString();
            mViewModel.setCurrentTheme(theme);
        });
        recyclerView.setAdapter(randomCardListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mViewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
        randomCardListAdapter.submitList(mViewModel.getRandomThemeCards());
        return view;
    }
}
