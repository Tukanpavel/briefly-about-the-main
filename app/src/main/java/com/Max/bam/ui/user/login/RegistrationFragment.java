package com.Max.bam.ui.user.login;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.Max.bam.R;
import com.Max.bam.data.entity.User;
import com.Max.bam.ui.user.UserViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegistrationFragment extends Fragment implements View.OnClickListener {
    private UserViewModel mViewModel;
    private AppCompatEditText mEMail;
    private AppCompatEditText mPassword;
    private AppCompatEditText mBDate;
    private AppCompatEditText mGender;
    private AppCompatEditText mName;
    private FirebaseAuth mAuth;
    private View v;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);

        v = view;

        mViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();

        mEMail = (AppCompatEditText) v.findViewById(R.id.registration_email);
        mPassword = (AppCompatEditText) v.findViewById(R.id.registration_password);


        AppCompatButton button = (AppCompatButton) v.findViewById(R.id.registration_btn_confirm);

        button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        mAuth.createUserWithEmailAndPassword(mEMail.getText().toString(), mPassword.getText().toString())
                .addOnCompleteListener(FragmentManager.findFragment(v).getActivity(), task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "Create new User:success");

                        User user = new User(mName.getText().toString(), mBDate.getText().toString(), mGender.getText().toString(), mEMail.getText().toString());
                        mViewModel.addUser(user);

                        NavHostFragment.findNavController(FragmentManager.findFragment(v))
                                .navigate(R.id.action_registrationFragment_to_profileFragment);
                    } else {
                        Log.w(TAG, "Create new User:failure", task.getException());
                        Toast.makeText(FragmentManager.findFragment(v).getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}