package com.example.util;

import java.time.LocalDateTime;

public class DateTimeFormatter {
    public static String format(LocalDateTime localDateTime) {
        return java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(localDateTime);
    }
}
