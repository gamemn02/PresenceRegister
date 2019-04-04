package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.login.LoginActivity;
import dz.deepwork.gamemn02.presenceregister.login.LoginFragment;

public class SignActivity extends AppCompatActivity {

    public static final String EXTRA_PASS_NUMBER = "dz.deepwork.gamemn02.extra-pass-number";

    private TextView mMemberNameText;
    private Member mLoggedInMember;

    @Inject
    MembersRepo mMembersRepo;

    public static Intent createIntent(Context context, String passNumber) {
        Intent intent = new Intent(context, SignActivity.class);
        intent.putExtra(EXTRA_PASS_NUMBER, passNumber);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        FragmentManager fragmentManager = getSupportFragmentManager();
        SignFragment signFragment = (SignFragment) fragmentManager.findFragmentById(R.id.frame_sign);
        if (signFragment == null) {
            signFragment = new SignFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_sign, signFragment)
                    .commit();
        }

//        RepoComponent.Singleton.getInstance().inject(this);
//        findMember();
    }

//    private void findMember() {
//        String memberPassNumber = getIntent().getStringExtra(EXTRA_PASS_NUMBER);
//        mMembersRepo.findMember(memberPassNumber).observe(this, new Observer<Member>() {
//            @Override
//            public void onChanged(@Nullable Member member) {
//                setupLoggedInMember(member);
//            }
//        });
//    }
//
//    private void setupLoggedInMember(Member loggedInMember) {
//        mLoggedInMember = loggedInMember;
//        // Update UI
//        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
//        mMemberNameText.setText(mLoggedInMember.name);
//    }

}
