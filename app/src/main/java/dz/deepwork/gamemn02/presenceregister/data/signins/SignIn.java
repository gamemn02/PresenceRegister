package dz.deepwork.gamemn02.presenceregister.data.signins;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sign_ins")
public class SignIn {

    @PrimaryKey(autoGenerate = true)
    public long uId;
    @ColumnInfo(name = "session_id")
    public long sessionId;
    @ColumnInfo(name = "time")
    public long time;
    @ColumnInfo(name = "room")
    public String room;

    public SignIn(long sessionId, long time, String room) {
        this.sessionId = sessionId;
        this.time = time;
        this.room = room;
    }

    @Override
    public boolean equals(Object obj) {
        SignIn signIn = (SignIn) obj;
        return sessionId == signIn.sessionId &&
                time == signIn.time &&
                room.equals(signIn.room);
    }
}
