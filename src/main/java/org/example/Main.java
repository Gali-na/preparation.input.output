package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        File directoryOld = new File("old Files");
        File directoryCopied = new File("copied Files");
        FileService fileService = new FileService();
        final boolean txt = fileService.copyFileConsideringExtension(directoryOld, directoryCopied, "txt");


    }
}