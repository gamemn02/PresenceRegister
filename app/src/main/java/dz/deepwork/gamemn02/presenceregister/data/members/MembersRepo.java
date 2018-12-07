package dz.deepwork.gamemn02.presenceregister.data.members;

public interface MembersRepo {

    Member findMember(String passNumber);
    void addMember(Member... members);
}
