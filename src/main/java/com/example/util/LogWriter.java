package com.example.util;

import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    public static void writeLog(String logMessage, String path) throws IOException {
        FileWriter fr = new FileWriter(path, true);
        fr.write(logMessage);
        fr.write('\n');
        fr.close();
    }
}
