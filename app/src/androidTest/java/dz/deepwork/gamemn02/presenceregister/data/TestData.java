package dz.deepwork.gamemn02.presenceregister.data;

import dz.deepwork.gamemn02.presenceregister.data.members.Member;
import dz.deepwork.gamemn02.presenceregister.data.sessions.Session;
import dz.deepwork.gamemn02.presenceregister.data.signins.SignIn;
import dz.deepwork.gamemn02.presenceregister.data.signs.Sign;

public class TestData {

    public static final String PASS_NUMBER_1 = "123456";
    public static final String PASS_NUMBER_2 = "987456";
    public static final String PASS_NUMBER_3 = "456321";
    public static final String PASS_NUMBER_4 = "98745";

    public static final String MEMBER1_NAME = "name";
    public static final String MEMBER1_PASS_NUMBER = PASS_NUMBER_1;
    public static final boolean MEMBER1_IS_ADMIN = false;
    public static final String MEMBER2_NAME = "name2";
    public static final String MEMBER2_PASS_NUMBER = PASS_NUMBER_2;
    public static final boolean MEMBER2_IS_ADMIN = true;
    public static final String MEMBER3_NAME = "name3";
    public static final String MEMBER3_PASS_NUMBER = PASS_NUMBER_3;
    public static final boolean MEMBER3_IS_ADMIN = false;

    public static final Member[] MEMBERS = {
            new Member(MEMBER1_NAME, MEMBER1_PASS_NUMBER, MEMBER1_IS_ADMIN),
            new Member(MEMBER2_NAME, MEMBER2_PASS_NUMBER, MEMBER2_IS_ADMIN),
            new Member(MEMBER3_NAME, MEMBER3_PASS_NUMBER, MEMBER3_IS_ADMIN),
    };

    public static final int SESSION1_BEGIN_TIME = 0;
    public static final int SESSION1_END_TIME = 2;
    public static final int SESSION1_MEMBER_ID = 1;
    public static final String SESSION1_ROOM = "B007";
    public static final String SESSION1_DETAILS = "Recitation E415";
    public static final int SESSION2_BEGIN_TIME = 1;
    public static final int SESSION2_END_TIME = 3;
    public static final int SESSION2_MEMBER_ID = 2;
    public static final String SESSION2_ROOM = "C101";
    public static final String SESSION2_DETAILS = "Recitation E111";
    public static final int SESSION3_BEGIN_TIME = 2;
    public static final int SESSION3_END_TIME = 4;
    public static final int SESSION3_MEMBER_ID = 3;
    public static final String SESSION3_ROOM = "A308";
    public static final String SESSION3_DETAILS = "Lab E223";

    public static final Session[] SESSIONS = {
            new Session(SESSION1_BEGIN_TIME, SESSION1_END_TIME,
                    SESSION1_MEMBER_ID, SESSION1_ROOM, SESSION1_DETAILS),
            new Session(SESSION2_BEGIN_TIME, SESSION2_END_TIME,
                    SESSION2_MEMBER_ID, SESSION2_ROOM, SESSION2_DETAILS),
            new Session(SESSION3_BEGIN_TIME, SESSION3_END_TIME,
                    SESSION3_MEMBER_ID, SESSION3_ROOM, SESSION3_DETAILS),
    };

    public static final int SIGN_IN_1_SESSION_ID = 1;
    public static final long SIGN_IN_1_TIME = 1;
    public static final String SIGN_IN_1_ROOM = SESSION1_ROOM;
    public static final int SIGN_IN_2_SESSION_ID = 2;
    public static final long SIGN_IN_2_TIME = 2;
    public static final String SIGN_IN_2_ROOM = SESSION2_ROOM;
    public static final int SIGN_IN_3_SESSION_ID = 3;
    public static final long SIGN_IN_3_TIME = 3;
    public static final String SIGN_IN_3_ROOM = SESSION3_ROOM;

    public static final SignIn[] SIGN_INS = {
            new SignIn(SIGN_IN_1_SESSION_ID, SIGN_IN_1_TIME, SIGN_IN_1_ROOM),
            new SignIn(SIGN_IN_2_SESSION_ID, SIGN_IN_2_TIME, SIGN_IN_2_ROOM),
            new SignIn(SIGN_IN_3_SESSION_ID, SIGN_IN_3_TIME, SIGN_IN_3_ROOM)
    };

    public static final String SIGN_1_MEMBER_NAME = MEMBER1_NAME;
    public static final long SIGN_1_SIGN_IN_TIME = SIGN_IN_1_TIME;
    public static final long SIGN_1_SIGN_OUT_TIME = SIGN_IN_1_TIME+3;
    public static final String SIGN_1_ROOM = SESSION1_ROOM;
    public static final String SIGN_1_DETAILS = SESSION1_DETAILS;
    public static final String SIGN_2_MEMBER_NAME = MEMBER2_NAME;
    public static final long SIGN_2_SIGN_IN_TIME = SIGN_IN_2_TIME;
    public static final long SIGN_2_SIGN_OUT_TIME = SIGN_IN_2_TIME+2;
    public static final String SIGN_2_ROOM = SESSION2_ROOM;
    public static final String SIGN_2_DETAILS = SESSION2_DETAILS;
    public static final String SIGN_3_MEMBER_NAME = MEMBER3_NAME;
    public static final long SIGN_3_SIGN_IN_TIME = SIGN_IN_3_TIME;
    public static final long SIGN_3_SIGN_OUT_TIME = SIGN_IN_3_TIME+1;
    public static final String SIGN_3_ROOM = SESSION3_ROOM;
    public static final String SIGN_3_DETAILS = SESSION3_DETAILS;

    public static final Sign[] SIGNS = {
            new Sign(SIGN_1_MEMBER_NAME, SIGN_1_SIGN_IN_TIME,
                    SIGN_1_SIGN_OUT_TIME, SIGN_1_ROOM, SIGN_1_DETAILS),
            new Sign(SIGN_2_MEMBER_NAME, SIGN_2_SIGN_IN_TIME,
                    SIGN_2_SIGN_OUT_TIME, SIGN_2_ROOM, SIGN_2_DETAILS),
            new Sign(SIGN_3_MEMBER_NAME, SIGN_3_SIGN_IN_TIME,
                    SIGN_3_SIGN_OUT_TIME, SIGN_3_ROOM, SIGN_3_DETAILS)
    };

}