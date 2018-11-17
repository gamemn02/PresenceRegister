package dz.deepwork.gamemn02.presenceregister.data;

public class MemberRepo {

    // EXAMPLE MEMBER PASS NUMBER AND ID
    public static final String MEMBER_PASS_NUMBER_EXAMPLE = "123456";
    private static final long MEMBER_ID_EXAMPLE = 1;
    // CORRESPONDING MEMBER NAME, REQUIRED ROOM, START TIME, END TIME, DETAILS
    public static final String MEMBER_FIRST_NAME_EXAMPLE = "first";
    public static final String MEMBER_LAST_NAME_EXAMPLE = "last";

    static public Member findCorrespondingMember(long id) {
        if (MEMBER_ID_EXAMPLE == id) {
            return new Member(id, MEMBER_FIRST_NAME_EXAMPLE, MEMBER_LAST_NAME_EXAMPLE,
                    MEMBER_PASS_NUMBER_EXAMPLE, false);
        } else {
            return null;
        }
    }
}
