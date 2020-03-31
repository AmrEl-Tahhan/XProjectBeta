package com.tahhan.xprojectbeta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tahhan.xprojectbeta.R;
import com.tahhan.xprojectbeta.view.ui.login.LoginFragment;
import com.tahhan.xprojectbeta.view.ui.login.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    public static final String LOGIN_FRAGMENT_TAG = "loginFragmentTag";
    public static final String REGISTER_FRAGMENT_TAG = "register_fragment_tag";
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag(LOGIN_FRAGMENT_TAG);
        registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentByTag(REGISTER_FRAGMENT_TAG);
        if (loginFragment == null && registerFragment == null) {
            loadLoginFragment();
        } else if (registerFragment == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    loginFragment, LOGIN_FRAGMENT_TAG);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    registerFragment, REGISTER_FRAGMENT_TAG);
        }
    }

    private void loadLoginFragment() {
        loginFragment = new LoginFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, loginFragment, LOGIN_FRAGMENT_TAG)
                .commit();
    }
}