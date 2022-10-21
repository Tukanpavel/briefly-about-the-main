package com.Max.bam.ui.theme.text;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;
import com.Max.bam.data.entity.ThemeCard;
import com.Max.bam.ui.theme.ThemeViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ThemeTextFragment extends Fragment {
    private ThemeViewModel mViewModel;

    public static ThemeTextFragment newInstance() {
        return new ThemeTextFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.theme_card_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        final ThemeTextListAdapter themeTextListAdapter = new ThemeTextListAdapter(
                new ThemeTextListAdapter.ThemeTextDiff());
        recyclerView.setAdapter(themeTextListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        String theme = ThemeTextFragmentArgs.fromBundle(getArguments()).getThemeName();
        mViewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
        List<ThemeCard> cards = mViewModel.getThemeCardsByTheme(theme).getValue();
        mViewModel.getThemeCardsByTheme(theme).observe(getViewLifecycleOwner(), themeTextListAdapter::submitList);
        return view;
    }
}
