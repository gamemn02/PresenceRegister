package dz.deepwork.gamemn02.presenceregister.sign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.PresenceRegisterApplication;
import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepoComponent;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

public class SignActivity extends AppCompatActivity {

    public static final String EXTRA_PASS_NUMBER = "dz.deepwork.gamemn02.extra-pass-number";

    private TextView mMemberNameText;
    // TODO rename mLogedInMember to mLoggedInMember
    private Member mLogedInMember;

    @Inject
    MembersRepo mMembersRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        MembersRepoComponent.Singleton.getInstance().inject(this);
        findMember();
        showMemberName();
    }

    private void findMember() {
        String memberPassNumber = getIntent().getStringExtra(EXTRA_PASS_NUMBER);
        mLogedInMember = mMembersRepo.findMember(memberPassNumber);
    }

    private void showMemberName() {
        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
        mMemberNameText.setText(mLogedInMember.name);
    }

}
