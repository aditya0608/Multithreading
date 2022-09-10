package com.aditya.copypaste;

import java.io.File;

public class Reader {
    private File file;
    public Reader(File file)
    {
        this.file=file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
