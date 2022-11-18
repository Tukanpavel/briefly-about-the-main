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
import com.Max.bam.ui.user.UserViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
public class LoginFragment extends Fragment implements View.OnClickListener {
    private AppCompatEditText mLogin;
    private AppCompatEditText mPassword;
    private FirebaseAuth mAuth;
    private View v;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_login, container, false);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser mUser = mAuth.getCurrentUser();

        mLogin = (AppCompatEditText) v.findViewById(R.id.username_login);
        mPassword = (AppCompatEditText) v.findViewById(R.id.password_login);

        AppCompatButton button = (AppCompatButton) v.findViewById(R.id.confirm_login_btn);

        button.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        mAuth.signInWithEmailAndPassword(mLogin.getText().toString(), mPassword.getText().toString())
                .addOnCompleteListener(FragmentManager.findFragment(v).getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            NavHostFragment.findNavController(FragmentManager.findFragment(v))
                                    .navigate(R.id.action_loginFragment_to_themeCardFragment);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(FragmentManager.findFragment(v).getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }
}