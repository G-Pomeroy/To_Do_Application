package com.gregpomeroy.todoj2ee.webd3102_assignment1_gregpomeroy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskHelper {
    public static String formatStatus(String status) {
        String step1 = status.replace("_", " ");

        String step2 = step1.toLowerCase();

        String re = "(\\b[a-z](?!\\s))";
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(step2);

        return matcher.replaceAll(matchResult -> matchResult.group().toUpperCase());
    }
}
