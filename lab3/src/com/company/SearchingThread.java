package com.company;
import java.io.File;

public class SearchingThread extends Thread {

    private SearchFile searchFile;
    private File[] files;

    public SearchingThread(File[] files, SearchFile searchFile) {
        this.searchFile= searchFile;
        this.files = files;
    }

    @Override
    public void run() {
        searchFile.Searching(files);
    }
}
