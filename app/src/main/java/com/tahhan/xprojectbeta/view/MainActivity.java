package com.tahhan.xprojectbeta.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tahhan.xprojectbeta.R;
import com.tahhan.xprojectbeta.view.ui.login.LoginFragment;
import com.tahhan.xprojectbeta.view.ui.login.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    public static final String LOGIN_FRAGMENT_TAG = "loginFragmentTag";
    public static final String REGISTER_FRAGMENT_TAG = "register_fragment_tag";
    public static final String LOGIN_FRAGMENT_TRANSACTION_TAG = "loginFragmentTransactionTag";
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;
    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        loginFragment = (LoginFragment) fm.findFragmentByTag(LOGIN_FRAGMENT_TAG);
        registerFragment = (RegisterFragment) fm.findFragmentByTag(REGISTER_FRAGMENT_TAG);
        if (loginFragment == null && registerFragment == null) {
            loadLoginFragment();
        } else if (registerFragment == null) {
            fm.beginTransaction().replace(R.id.fragment_container,
                    loginFragment, LOGIN_FRAGMENT_TAG);
        } else {
            fm.beginTransaction().replace(R.id.fragment_container,
                    registerFragment, REGISTER_FRAGMENT_TAG);
        }
    }

    private void loadLoginFragment() {
        loginFragment = new LoginFragment();
        fm
                .beginTransaction()
                .replace(R.id.fragment_container, loginFragment, LOGIN_FRAGMENT_TAG)
                .addToBackStack(LOGIN_FRAGMENT_TRANSACTION_TAG)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (loginFragment.isVisible()) {
            finish();
        } else super.onBackPressed();

    }
}