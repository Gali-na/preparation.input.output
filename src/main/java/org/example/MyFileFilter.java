package org.example;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileFilter implements FilenameFilter {
    private File dir;
    private String extension;

    public MyFileFilter(File dir, String extension) {
        this.dir = dir;
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String extension) {
         String[] listFileName = dir.list();
        for (String faleNames:listFileName) {
             String[] split = faleNames.split(".");
             if(split[1].equals(extension)){
                 return true;
             }else {
                 return  false;
             }
        }
        return  false;

    }



}
