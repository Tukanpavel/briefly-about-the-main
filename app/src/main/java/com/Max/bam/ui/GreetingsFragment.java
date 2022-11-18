package com.Max.bam.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.Max.bam.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GreetingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
public class GreetingsFragment extends Fragment implements View.OnClickListener {

    public static GreetingsFragment newInstance() {
        return new GreetingsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_greetings, container, false);

        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();

        if (mUser != null) {
            NavHostFragment.findNavController(this).navigate(R.id.action_greetingsFragment_to_profileFragment);
        } else {

            AppCompatButton loginButton = (AppCompatButton) view.findViewById(R.id.login_button);
            AppCompatButton registrationButton = (AppCompatButton) view.findViewById(R.id.registration_button);

            loginButton.setOnClickListener(this);
            registrationButton.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registration_button:
                NavHostFragment.findNavController(this).navigate(GreetingsFragmentDirections.actionGreetingsFragmentToRegistrationFragment());
                break;
            case R.id.login_button:
                NavHostFragment.findNavController(this).navigate(GreetingsFragmentDirections.actionGreetingsFragmentToLoginFragment());
                break;
        }
    }
}