package com.knkn.knockknock;

import java.sql.Timestamp;
import java.util.Random;

public class KnKnUtility {
    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static String generateIdentifyNumber(){
        int random = (int)(new Random().nextInt(9000)) + 1000;
        return Integer.toString(random);
    }
}
