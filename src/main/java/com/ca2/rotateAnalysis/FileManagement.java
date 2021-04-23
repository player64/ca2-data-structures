package com.ca2.rotateAnalysis;
import java.io.*;

/**
 * It creates the file
 */
public class FileManagement {
    private final String fileName;

    /**
     * It initialise by setting the file name
     * @param fileName String the file name
     */
    public FileManagement(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Creates the file in the root directory
     */
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

    /**
     * Checks is file with file exists
     * @return boolean
     */
    private boolean fileExists() {
        File file = new File(fileName);
        return file.exists();
    }

    /**
     * Append to the file the given string
     * @param text String
     */
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
