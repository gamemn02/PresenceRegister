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

public class LoginActivity extends AppCompatActivity {

    private static final String TAG_LOGIN_FRAGMENT = LoginFragment.class.getName();

    public static Intent createIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager fragmentManager = getSupportFragmentManager();
        LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentByTag(TAG_LOGIN_FRAGMENT);
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_login, loginFragment, TAG_LOGIN_FRAGMENT)
                    .commit();
        }
    }

//    public void onClickDigit(View view) {
//        Button digitButton = (Button) view;
//        addPassDigit(digitButton.getText().toString());
//    }
//
//    public void onClickClear(View view) {
//        EditText passNumberEdit = (EditText) findViewById(R.id.et_pass_number);
//        passNumberEdit.setText("");
//    }
//
//    public void addPassDigit(String digit) {
//        EditText passNumberEdit = (EditText) findViewById(R.id.et_pass_number);
//        String newPassNumber = passNumberEdit.getText() + digit;
//        passNumberEdit.setText(newPassNumber);
//    }
}
