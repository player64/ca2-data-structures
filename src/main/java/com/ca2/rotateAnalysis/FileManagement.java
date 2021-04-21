package com.ca2.rotateAnalysis;

import java.io.*;

public class FileManagement {
    private final String fileName;

    public FileManagement(String fileName) {
        this.fileName = fileName;
    }

    private void createFile() {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean fileExists() {
        File file = new File(fileName);
        return file.exists();
    }

    public void writeFile(String text) {
        if (!fileExists()) {
            createFile();
        }

        try {
            FileWriter  file = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(file);
            bw.write(text+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
