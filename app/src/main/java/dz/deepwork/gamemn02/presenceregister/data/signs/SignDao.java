package dz.deepwork.gamemn02.presenceregister.data.signs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface SignDao {

    @Insert
    long[] insert(Sign... signs);

    @Query("SELECT * FROM signs")
    Sign[] queryAll();

}
