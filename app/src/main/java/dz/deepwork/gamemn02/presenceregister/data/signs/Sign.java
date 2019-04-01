package dz.deepwork.gamemn02.presenceregister.data.signs;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "signs")
public class Sign {

    @PrimaryKey(autoGenerate = true)
    public long uId;
    @ColumnInfo(name = "member_name")
    public String memberName;
    @ColumnInfo(name = "sign_in_time")
    public long signInTime;
    @ColumnInfo(name = "sign_out_time")
    public long signOutTime;
    @ColumnInfo(name = "room")
    public String room;
    @ColumnInfo(name = "details")
    public String details;

    public Sign(String memberName, long signInTime, long signOutTime, String room, String details) {
        this.memberName = memberName;
        this.signInTime = signInTime;
        this.signOutTime = signOutTime;
        this.room = room;
        this.details = details;
    }

    @Override
    public boolean equals(Object obj) {
        Sign sign = (Sign) obj;
        return memberName.equals(sign.memberName) &&
                signInTime == sign.signInTime &&
                signOutTime == signOutTime &&
                room.equals(sign.room) &&
                details.equals(sign.details);
    }
}
