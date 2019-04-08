package dz.deepwork.gamemn02.presenceregister.sign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;

public class SignActivity extends AppCompatActivity {

    private static final String EXTRA_MEMBER_PASS_NUMBER = "dz.deepwork.gamemn02.extra-member-pass-number";

    private TextView mMemberNameText;
    private Member mLoggedInMember;


    public static Intent createIntent(Context context, String passNumber) {
        Intent intent = new Intent(context, SignActivity.class);
        intent.putExtra(EXTRA_MEMBER_PASS_NUMBER, passNumber);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        String passNumber = getIntent().getStringExtra(EXTRA_MEMBER_PASS_NUMBER);
        if (passNumber == null) {
            finish();
            return;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        SignFragment signFragment = (SignFragment) fragmentManager.findFragmentById(R.id.frame_sign);
        if (signFragment == null) {
            signFragment = SignFragment.newInstance(passNumber);
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_sign, signFragment)
                    .commit();
        }
    }

//    private void findMember() {
//        String memberPassNumber = getIntent().getStringExtra(EXTRA_MEMBER_PASS_NUMBER);
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
