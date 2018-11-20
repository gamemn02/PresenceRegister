package dz.deepwork.gamemn02.presenceregister.data.members;

public class Member {

    public static final int ID_NOT_MEMBER = -1;

    public int id;
    public String name;
    public String passNumber;
    public boolean isAdmin;

    public Member(String name, String passNumber, boolean isAdmin) {
        this.name = name;
        this.passNumber = passNumber;
        this.isAdmin = isAdmin;
    }

    public Member(int id, String name, String passNumber, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.passNumber = passNumber;
        this.isAdmin = isAdmin;
    }
}
