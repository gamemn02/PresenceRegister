package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Member {

    public static final int ID_NOT_MEMBER = -1;

    @PrimaryKey
    public int id;
    public String name;
    public String passNumber;
    public boolean isAdmin;

    public Member(String name, String passNumber, boolean isAdmin) {
        this.name = name;
        this.passNumber = passNumber;
        this.isAdmin = isAdmin;
    }
}
