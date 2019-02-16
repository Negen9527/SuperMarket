package com.negen.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtil {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
    public static String timestamp2Str(Timestamp timestamp){
        return sdf.format(timestamp);
    }
}
