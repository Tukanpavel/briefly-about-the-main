package com.Max.bam.ui.user.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.Max.bam.R;
import com.Max.bam.ui.user.UserViewModel;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
public class LoginFragment extends Fragment implements View.OnClickListener {
    private UserViewModel mViewModel;
    private AppCompatEditText mLogin;
    private AppCompatEditText mPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        mLogin = (AppCompatEditText) v.findViewById(R.id.username_login);
        mPassword = (AppCompatEditText) v.findViewById(R.id.password_login);

        AppCompatButton button = (AppCompatButton) v.findViewById(R.id.confirm_login_btn);

        button.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.confirm_login_btn:
                String email = mLogin.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                mViewModel.getUser(email, password).observe(getViewLifecycleOwner(), (id) -> {
                    if (id!=null)
                });
        }
    }
}