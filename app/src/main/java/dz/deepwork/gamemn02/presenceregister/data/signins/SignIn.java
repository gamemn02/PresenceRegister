package dz.deepwork.gamemn02.presenceregister.data.signins;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sign_ins")
public class SignIn {

    @PrimaryKey(autoGenerate = true)
    public long uId;
    @ColumnInfo(name = "session_id")
    public int sessionId;
    @ColumnInfo(name = "time")
    public long time;
    @ColumnInfo(name = "room")
    public String room;

    public SignIn(int sessionId, long time, String room) {
        this.sessionId = sessionId;
        this.time = time;
        this.room = room;
    }

    @Override
    public boolean equals(Object obj) {
        SignIn signIn = (SignIn) obj;
        return uId == signIn.uId &&
                sessionId == signIn.sessionId &&
                time == signIn.time &&
                room.equals(signIn.room);
    }
}
