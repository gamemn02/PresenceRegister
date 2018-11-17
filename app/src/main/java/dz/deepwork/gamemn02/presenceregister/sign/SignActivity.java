package dz.deepwork.gamemn02.presenceregister.sign;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import dz.deepwork.gamemn02.presenceregister.R;

public class SignActivity extends AppCompatActivity {

    public static final String EXTRA_PASS_NUMBER = "dz.deepwork.gamemn02.extra-pass-number";
    public static final String EXTRA_ID = "dz.deepwork.gamemn02.extra-id";

    private TextView mMemberNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
        mMemberNameText.setText("teacher1");
    }

}
