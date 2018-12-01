package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

//TODO rename session table name to sessions
@Entity
public class Session {

    //TODO rename columns
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int beginTime;
    public int endTime;
    public int memberId;
    public String room;
    public String details;

    public Session(int beginTime, int endTime, int memberId, String room, String details) {
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
