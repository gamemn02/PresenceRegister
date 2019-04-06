package dz.deepwork.gamemn02.presenceregister.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.databinding.LoginFragmentBinding;

public class LoginFragment extends Fragment {

    private LoginFragmentBinding mLoginFragmentBinding;
    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mLoginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        mLoginFragmentBinding.setUx(new LoginUx(this));
        return mLoginFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    public EditText getPassNumberEdit() {
        return mLoginFragmentBinding.content.etPassNumber;
    }

    public void checkPassNumber(String passNumber, Observer<Member> resultObserver) {
        mViewModel.findMember(passNumber).observe(this, resultObserver);
    }

    public void launchSign(String passNumber) {
        ((LoginResultListener) getActivity()).launchSignFragment(passNumber);
    }
}
