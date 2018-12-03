package dz.deepwork.gamemn02.presenceregister.data.signs;

import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;

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

    @Override
    public boolean equals(Object obj) {
        Sign sign = (Sign) obj;
        return uId == sign.uId &&
                memberName.equals(sign.memberName) &&
                signInTime == sign.signInTime &&
                signOutTime == signOutTime &&
                room.equals(sign.room) &&
                details.equals(sign.details);
    }
}
