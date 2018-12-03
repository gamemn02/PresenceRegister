package dz.deepwork.gamemn02.presenceregister.data.signs;

public class Sign {

    public int uId;
    public String memberName;
    public long signInTime;
    public long signOutTime;
    public String room;
    public String details;

    public Sign(String memberName, long signInTime, long signOutTime, String room, String details) {
        this.memberName = memberName;
        this.signInTime = signInTime;
        this.signOutTime = signOutTime;
        this.room = room;
        this.details = details;
    }
}
