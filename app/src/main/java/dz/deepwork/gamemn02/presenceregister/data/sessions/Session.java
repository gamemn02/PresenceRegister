package dz.deepwork.gamemn02.presenceregister.data.sessions;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Session {

    @PrimaryKey
    public int id;
    public int beginTime;
    public int endTime;
    public int memberId;
    public String room;
    public String details;

    public Session(int id, int beginTime, int endTime, int memberId, String room, String details) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.memberId = memberId;
        this.room = room;
        this.details = details;
    }
}
