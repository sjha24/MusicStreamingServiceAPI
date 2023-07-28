package com.saurav.MusicStreamingService.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@admin\\.com$";
    public static boolean isValidUser(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
