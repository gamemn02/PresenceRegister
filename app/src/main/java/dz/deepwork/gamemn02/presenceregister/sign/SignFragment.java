package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Observable;
import java.util.Observer;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.Notified;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.databinding.SignFragmentBinding;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;

public class SignFragment extends Fragment implements Notified {

    private static final String BUNDLE_MEMBER_PASS_NUMBER = "bundle-member-pass-number";

    private SignViewModel mViewModel;
    private SignFragmentBinding mSignFragmentBinding;

    public static SignFragment newInstance(String memberPassNumber) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_MEMBER_PASS_NUMBER, memberPassNumber);
        SignFragment signFragment = new SignFragment();
        signFragment.setArguments(bundle);
        return signFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mSignFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.sign_fragment, container, false);
        mSignFragmentBinding.setLifecycleOwner(this);
        return mSignFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String memberPassNumber = getArguments().getString(BUNDLE_MEMBER_PASS_NUMBER);
        mViewModel = ViewModelProviders.of(this).get(SignViewModel.class);
        mViewModel.init(memberPassNumber);
        mViewModel.setSignInNotified(this);
        mSignFragmentBinding.setViewModel(mViewModel);
    }

    @Override
    public void onNotified() {
        ((SignResultListener)getActivity()).onSignedIn();
    }
}
