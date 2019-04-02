package dz.deepwork.gamemn02.presenceregister.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginUiController {

    private EditText mPassNumberEditText;

    public LoginUiController(EditText passNumberEditText) {
        this.mPassNumberEditText = passNumberEditText;
    }

    public void onClickDigit(View view) {
        Button button = (Button) view;
        addPassDigit(button.getText().toString());
    }

    private void addPassDigit(String digit) {
        String newPassNumber = mPassNumberEditText.getText() + digit;
        mPassNumberEditText.setText(newPassNumber);
    }

    public void onClickClear() {
        mPassNumberEditText.setText("");
    }
}
