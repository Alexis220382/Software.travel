package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class ReadFile {

    BufferedReader reader;

    public String read(String path) throws IOException {
        reader = new BufferedReader (new FileReader(path));
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }
}
