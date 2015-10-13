package com.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ivanovskiy Alexey on 13.10.2015.
 */
public class WriteFile {

    BufferedWriter writer;

    public void write(String path, String value) throws IOException {
        writer = new BufferedWriter(new FileWriter(path));
        writer.write(value);
    }

    public void close() throws IOException {
        writer.close();
    }
}
