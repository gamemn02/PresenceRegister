package dz.deepwork.gamemn02.presenceregister.sign;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
    }

    private void findMember() {
        String memberPassNumber = getIntent().getStringExtra(EXTRA_PASS_NUMBER);
        mMembersRepo.findMember(memberPassNumber).observe(this, new Observer<Member>() {
            @Override
            public void onChanged(@Nullable Member member) {
                setupLoggedInMember(member);
            }
        });
    }

    private void setupLoggedInMember(Member loggedInMember) {
        mLoggedInMember = loggedInMember;
        // Update UI
        mMemberNameText = (TextView) findViewById(R.id.tv_member_name);
        mMemberNameText.setText(mLoggedInMember.name);
    }

}
