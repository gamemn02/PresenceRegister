package dz.deepwork.gamemn02.presenceregister.data;

public class Member {

    public static final long ID_NOT_MEMBER = -1;

    private long mId;
    private String mFirstName;
    private String mLastName;
    private String mPassNumber;
    private boolean mIsAdmin;

    public Member(String firstName, String lastName, String passNumber, boolean isAdmin) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mPassNumber = passNumber;
        this.mIsAdmin = isAdmin;
    }

    public Member(long id, String firstName, String lastName, String passNumber, boolean isAdmin) {
        this.mId = id;
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mPassNumber = passNumber;
        this.mIsAdmin = isAdmin;
    }

    public long getId() {
        return mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getPassNumber() {
        return mPassNumber;
    }

    public boolean isAdmin() {
        return mIsAdmin;
    }
}
