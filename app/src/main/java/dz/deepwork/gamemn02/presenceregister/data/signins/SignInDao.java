package dz.deepwork.gamemn02.presenceregister.data.signins;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface SignInDao {

    @Insert
    long[] insert(SignIn... signIns);

    @Query("SELECT * FROM sign_ins  WHERE session_id = :sessionId")
    SignIn find(long sessionId);

    @Delete
    void delete(SignIn... signIn);
}
