package com.Max.bam.ui.user.profile.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.Max.bam.R;
import com.Max.bam.data.entity.User;
import com.Max.bam.ui.user.UserViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
public class ProfileFragment extends Fragment {
    private UserViewModel viewModel;
    private FirebaseAuth mAuth;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        AppCompatTextView nameField = view.findViewById(R.id.profile_name);
        AppCompatTextView emailField = view.findViewById(R.id.profile_email);
        AppCompatTextView genderField = view.findViewById(R.id.profile_gender);
        AppCompatTextView bDateField = view.findViewById(R.id.profile_birth_date);
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();

        final Observer<User> userObserver = new Observer<User>() {
            @Override
            public void onChanged(User user) {
                nameField.setText(user.name);
                emailField.setText(user.eMail);
                genderField.setText(user.gender);
                bDateField.setText(user.birthDate.toString());
            }
        };

        viewModel.getUser(mUser.getEmail()).observe(getViewLifecycleOwner(), userObserver);
        return view;
    }
}