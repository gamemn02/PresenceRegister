package dz.deepwork.gamemn02.presenceregister.data.members;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface MemberDao {

    @Insert
    void insert(Member... members);

    @Query("SELECT * FROM members WHERE pass_number = :passNumber")
    Member find(String passNumber);
}
