package dz.deepwork.gamemn02.presenceregister.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginUx {

    private LoginFragment mLoginFragment;

    public LoginUx(LoginFragment loginFragment) {
        this.mLoginFragment = loginFragment;
    }

    public void onClickDigit(View view) {
        Button button = (Button) view;
        addPassDigit(button.getText().toString());
    }

    private void addPassDigit(String digit) {
        EditText mPassNumberEdit = mLoginFragment.getPassNumberEdit();
        String newPassNumber = mPassNumberEdit.getText() + digit;
        mPassNumberEdit.setText(newPassNumber);
        if (newPassNumber.length() == 6) {
            mLoginFragment.checkPassNumber(newPassNumber, member -> {
                if (member != null) {
                    mLoginFragment.launchSign(newPassNumber);
                }
                onClickClear();
            });
        }
    }

    public void onClickClear() {
        EditText mPassNumberEdit = mLoginFragment.getPassNumberEdit();
        mPassNumberEdit.setText("");
    }


}
