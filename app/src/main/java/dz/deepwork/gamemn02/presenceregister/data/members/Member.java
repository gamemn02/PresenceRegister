package dz.deepwork.gamemn02.presenceregister.data.members;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "members")
public class Member {

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "pass_number")
    public String passNumber;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "is_admin")
    public boolean isAdmin;


    public Member(String name, String passNumber, boolean isAdmin) {
        this.name = name;
        this.passNumber = passNumber;
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object obj) {
        Member member = (Member) obj;
        return name.equals(member.name) &&
                passNumber.equals(member.passNumber) &&
                isAdmin == member.isAdmin;
    }
}
