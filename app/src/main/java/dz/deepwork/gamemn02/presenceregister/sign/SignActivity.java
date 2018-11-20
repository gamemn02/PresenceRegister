package dz.deepwork.gamemn02.presenceregister.sign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.PresenceRegisterApplication;
import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

public class SignActivity extends AppCompatActivity {

    public static final String EXTRA_PASS_NUMBER = "dz.deepwork.gamemn02.extra-pass-number";
    public static final String EXTRA_ID = "dz.deepwork.gamemn02.extra-id";

    private TextView mMemberNameText;
    private Member mLogedInMember;

    @Inject
    MembersRepo mMembersRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        PresenceRegisterApplication.get(this).getMemberRepo().inject(this);
        findMember();
        showMemberName();
    }

    private void findMember() {
        long memberId = getIntent().getIntExtra(EXTRA_ID, Member.ID_NOT_MEMBER);
        mLogedInMember = mMembersRepo.findCorrespondingMember(memberId);
    }

    private void showMemberName() {
        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
        mMemberNameText.setText(mLogedInMember.name);
    }

}
