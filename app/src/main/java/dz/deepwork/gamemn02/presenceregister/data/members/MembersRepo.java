package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.lifecycle.LiveData;

public interface MembersRepo {
    LiveData<Member> findMember(String passNumber);
    void addMembers(Member... members);
}
