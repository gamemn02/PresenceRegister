package dz.deepwork.gamemn02.presenceregister.login;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.databinding.LoginFragmentBinding;

public class LoginFragment extends Fragment {

    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LoginFragmentBinding loginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        loginFragmentBinding.setViewmodel(mViewModel);
        loginFragmentBinding.setController(new LoginUiController(loginFragmentBinding.content.etPassNumber));
        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

//    public void onClickDigit(View view) {
//        Button digitButton = (Button) view;
//        addPassDigit(digitButton.getText().toString());
//    }
//
//    public void onClickClear(View view) {
//        EditText passNumberEdit = (EditText) getView().findViewById(R.id.et_pass_number);
//        passNumberEdit.setText("");
//    }
//
//    public void addPassDigit(String digit) {
//        EditText passNumberEdit = (EditText) getView().findViewById(R.id.et_pass_number);
//        String newPassNumber = passNumberEdit.getText() + digit;
//        passNumberEdit.setText(newPassNumber);
//    }
}
