package dz.deepwork.gamemn02.presenceregister.data.members;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface MemberDao {

    @Insert
    void insert(Member... members);

    //TODO rename member table name to members
    @Query("SELECT * FROM member WHERE pass_number = :passNumber")
    Member find(String passNumber);
}
