package dz.deepwork.gamemn02.presenceregister.data.signins;

public class SignIn {

    public int id;
    public int sessionId;
    public long signInTime;
    public String room;

    public SignIn(int sessionId, long signInTime, String room) {
        this.sessionId = sessionId;
        this.signInTime = signInTime;
        this.room = room;
    }
}
