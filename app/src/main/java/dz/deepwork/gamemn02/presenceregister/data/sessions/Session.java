package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sessions")
public class Session {

    @PrimaryKey(autoGenerate = true)
    public long uId;
    @ColumnInfo(name = "time")
    public SessionTime time;
    @ColumnInfo(name = "size")
    public int size;
    @ColumnInfo(name = "member_Id")
    public long memberId;
    @ColumnInfo(name = "room")
    public String room;
    @ColumnInfo(name = "details")
    public String details;

    public Session(SessionTime time, int size, long memberId, String room, String details) {
        this.time = time;
        this.size = size;
        this.memberId = memberId;
        this.room = room;
        this.details = details;
    }

    @Override
    public boolean equals(Object obj) {
        Session session = (Session) obj;
        return time.equals(session.time) &&
                size == session.size &&
                memberId == session.memberId &&
                room.equals(session.room) &&
                details.equals(session.details);
    }
}
