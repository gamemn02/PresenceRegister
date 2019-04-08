package dz.deepwork.gamemn02.presenceregister.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;
import dz.deepwork.gamemn02.presenceregister.login.LoginFragment;
import dz.deepwork.gamemn02.presenceregister.login.LoginResultListener;
import dz.deepwork.gamemn02.presenceregister.register.RegisterFragment;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;
import dz.deepwork.gamemn02.presenceregister.sign.SignFragment;

public class MainActivity extends AppCompatActivity implements LoginResultListener {

    private static final String BUNDLE_LOGIN_PASS_NUMBER = "bundle-login-pass-number";
    private FragmentManager mFragmentManager;
    private String mLoginPassNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        RegisterFragment registerFragment = (RegisterFragment) mFragmentManager.findFragmentById(R.id.frame_register);
        if (registerFragment == null) {
            registerFragment = new RegisterFragment();
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_register, registerFragment)
                    .commit();
        }

        if(savedInstanceState != null)
            mLoginPassNumber = savedInstanceState.getString(BUNDLE_LOGIN_PASS_NUMBER);

        if (isLandscape()) {
            Fragment curFragment = (Fragment) mFragmentManager.findFragmentById(R.id.frame_login);
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            if (mLoginPassNumber == null) {
                ft.replace(R.id.frame_login, new LoginFragment());
            } else {
                ft.replace(R.id.frame_login, SignFragment.newInstance(mLoginPassNumber));
            }
            ft.commit();
        } else {
            if (mLoginPassNumber != null) {
                Intent intent = SignActivity.createIntent(this, mLoginPassNumber);
                startActivity(intent);

                mLoginPassNumber = null;
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(BUNDLE_LOGIN_PASS_NUMBER, mLoginPassNumber);
        super.onSaveInstanceState(outState);
    }

    private boolean isLandscape() {
        ViewGroup loginLayout = findViewById(R.id.frame_login);
        return loginLayout != null;
    }

    public void onClickSign(View view) {
        startActivity(LoginActivity.createIntent(this));
    }

    @Override
    public void launchSignFragment(String passNumber) {
        Fragment curFragment = mFragmentManager.findFragmentById(R.id.frame_login);
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.replace(R.id.frame_login, SignFragment.newInstance(passNumber));
        ft.commit();

        mLoginPassNumber = passNumber;
    }


}
