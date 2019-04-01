package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "sessions")
public class Session {

    @PrimaryKey(autoGenerate = true)
    public long uId;
    @ColumnInfo(name = "begin_time")
    public int beginTime;
    @ColumnInfo(name = "end_time")
    public int endTime;
    @ColumnInfo(name = "member_Id")
    public long memberId;
    @ColumnInfo(name = "room")
    public String room;
    @ColumnInfo(name = "details")
    public String details;

    public Session(int beginTime, int endTime, long memberId, String room, String details) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.memberId = memberId;
        this.room = room;
        this.details = details;
    }

    @Override
    public boolean equals(Object obj) {
        Session session = (Session) obj;
        return beginTime == session.beginTime &&
                endTime == session.endTime &&
                memberId == session.memberId &&
                room.equals(session.room) &&
                details.equals(session.details);
    }
}
