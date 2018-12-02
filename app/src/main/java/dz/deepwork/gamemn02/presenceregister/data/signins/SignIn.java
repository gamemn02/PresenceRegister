package dz.deepwork.gamemn02.presenceregister.data.signins;

public class SignIn {

    public int id;
    public int sessionId;
    public long time;
    public String room;

    public SignIn(int sessionId, long time, String room) {
        this.sessionId = sessionId;
        this.time = time;
        this.room = room;
    }
}
