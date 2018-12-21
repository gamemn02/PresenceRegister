package dz.deepwork.gamemn02.presenceregister.sign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.RepoComponent;
import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.members.MembersRepo;

public class SignActivity extends AppCompatActivity {

    public static final String EXTRA_PASS_NUMBER = "dz.deepwork.gamemn02.extra-pass-number";

    private TextView mMemberNameText;
    private Member mLoggedInMember;

    @Inject
    MembersRepo mMembersRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        RepoComponent.Singleton.getInstance().inject(this);
        findMember();
        showMemberName();
    }

    private void findMember() {
        String memberPassNumber = getIntent().getStringExtra(EXTRA_PASS_NUMBER);
        mLoggedInMember = mMembersRepo.findMember(memberPassNumber);
    }

    private void showMemberName() {
        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
        mMemberNameText.setText(mLoggedInMember.name);
    }

}
