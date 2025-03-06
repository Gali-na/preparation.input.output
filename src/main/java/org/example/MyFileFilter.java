package org.example;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class MyFileFilter implements FileFilter {
    private String extension;
    public MyFileFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean accept(File file) {
        String[] split = file.getName().split("\\.");
        if (split[1].equals(this.extension)) {
            return true;
        } else {
            return false;
        }
    }
}
