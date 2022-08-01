package com.example.parserlog.utils;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class ReadLogsUtil {

    /**
     * Method than read log file
     * @param url - url to log file
     * @return FileReader
     */
    public FileReader read(String url) {
        FileReader fileReader = null;
        try {
            File file = new File(url);
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }
}
