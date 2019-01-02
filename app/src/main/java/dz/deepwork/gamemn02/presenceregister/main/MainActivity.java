package dz.deepwork.gamemn02.presenceregister.main;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;
import dz.deepwork.gamemn02.presenceregister.login.LoginFragment;
import dz.deepwork.gamemn02.presenceregister.register.RegisterFragment;

public class MainActivity extends AppCompatActivity {


    private static final String TAG_REGISTER_FRAGMENT = RegisterFragment.class.getName();
    private static final String TAG_LOGIN_FRAGMENT = LoginFragment.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        RegisterFragment registerFragment = (RegisterFragment) fragmentManager.findFragmentByTag(TAG_REGISTER_FRAGMENT);
        if (registerFragment == null) {
            registerFragment = new RegisterFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_register, registerFragment, TAG_REGISTER_FRAGMENT)
                    .commit();
        }

        LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentByTag(TAG_LOGIN_FRAGMENT);
        ViewGroup loginLayout = findViewById(R.id.frame_login);
        if (loginFragment == null && loginLayout != null) {
            loginFragment = new LoginFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_login, loginFragment, TAG_LOGIN_FRAGMENT)
                    .commit();
        }
    }

    public void onClickSign(View view) {
        startActivity(LoginActivity.createIntent(this));
    }
}
