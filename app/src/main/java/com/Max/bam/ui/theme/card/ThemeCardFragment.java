package com.Max.bam.ui.theme.card;

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
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Max.bam.R;
import com.Max.bam.ui.theme.ThemeViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ThemeCardFragment extends Fragment {
    private ThemeViewModel mViewModel;

    public static ThemeCardFragment newInstance() {
        return new ThemeCardFragment();
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

        // вот эта лямбда - хуйня из stack overflow, наверное, есть способ получше. По-видимому, нет.

        final ThemeCardListAdapter themeCardListAdapter = new ThemeCardListAdapter(
                new ThemeCardListAdapter.ThemeCardDiff(), (v, position) -> {
            LinearLayout linearLayout = (LinearLayout) v;
            AppCompatTextView textView = (AppCompatTextView) linearLayout.getChildAt(0);
            String theme = textView.getText().toString();
            //TODO: убрать из ThemeViewModel функционал setCurrentThem и вырезать его из кода
            //mViewModel.setCurrentTheme(theme);
            ThemeCardFragmentDirections.ActionThemeCardFragmentToThemeTextFragment action =
                    ThemeCardFragmentDirections.actionThemeCardFragmentToThemeTextFragment();
            action.setThemeName(theme);
            NavHostFragment.findNavController(this).navigate(action);
        });

        recyclerView.setAdapter(themeCardListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mViewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
        mViewModel.getThemeCards().observe(getViewLifecycleOwner(), themeCardListAdapter::submitList);
        return view;
    }
}
