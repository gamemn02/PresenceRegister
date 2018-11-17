package dz.deepwork.gamemn02.presenceregister.sign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import dz.deepwork.gamemn02.presenceregister.R;
import dz.deepwork.gamemn02.presenceregister.data.Member;
import dz.deepwork.gamemn02.presenceregister.data.MemberRepo;
import dz.deepwork.gamemn02.presenceregister.utils.StringFormats;

public class SignActivity extends AppCompatActivity {

    public static final String EXTRA_PASS_NUMBER = "dz.deepwork.gamemn02.extra-pass-number";
    public static final String EXTRA_ID = "dz.deepwork.gamemn02.extra-id";

    private TextView mMemberNameText;
    private Member mCorrespondingMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        findMember();
        showMemberName();
    }

    private void findMember() {
        long memberId = getIntent().getLongExtra(EXTRA_ID, Member.ID_NOT_MEMBER);
        mCorrespondingMember = MemberRepo.findCorrespondingMember(memberId);
    }

    private void showMemberName() {
        String memberName = StringFormats.composeName(
                mCorrespondingMember.getFirstName(), mCorrespondingMember.getLastName());
        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
        mMemberNameText.setText(memberName);
    }

}
