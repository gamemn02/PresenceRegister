package dz.deepwork.gamemn02.presenceregister.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.sign.SignActivity;

public class LoginActivity extends AppCompatActivity implements LoginResultListener {

    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentById(R.id.frame_login);
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_login, loginFragment)
                    .commit();
        }
    }

    @Override
    public void onCorrectPassNumber(String passNumber) {
        Intent intent = SignActivity.createIntent(this, passNumber);
        startActivity(intent);
        finish();
    }
}
