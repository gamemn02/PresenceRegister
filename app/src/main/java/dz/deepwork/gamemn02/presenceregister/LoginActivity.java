package dz.deepwork.gamemn02.presenceregister;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickDigit(View view) {
        Button digitButton = (Button) view;
        addPassDigit(digitButton.getText().toString());
    }

    public void onClickClear(View view) {
        EditText passNumberEdit = (EditText) findViewById(R.id.et_pass_number);
        passNumberEdit.setText("");
    }

    public void addPassDigit(String digit) {
        EditText passNumberEdit = (EditText) findViewById(R.id.et_pass_number);
        String newPassNumber = passNumberEdit.getText() + digit;
        passNumberEdit.setText(newPassNumber);
    }
}
