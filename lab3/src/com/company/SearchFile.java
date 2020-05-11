package com.company;
import java.io.File;
import java.util.ArrayList;


public class SearchFile extends Thread {
    private String search;
    private File path;
    private ArrayList<File> found = new ArrayList<>();
    private ArrayList<Thread> threads = new ArrayList<>();
    private File[] files;
    private Thread thr;

    public SearchFile(String search, File path) {
        super();
        this.search = search;
        this.path = path;
        files = path.listFiles();
        thr = new Thread(this);
        thr.start();
        try{
            thr.join();
        }
        catch (InterruptedException e){
            e.getMessage();
        }
    }

    public void Searching(File[] files) {
        if (files == null) return;
        for (File i : files) {
            if (i.isFile() && i.getName().equals(search)) {
                System.out.format("%s has found %s in %s\n", Thread.currentThread().getName(), i.getName(), i.getParent());
                found.add(i);
            }
            if (i.isDirectory()) {
                Thread newThread = new Thread(new SearchingThread(i.listFiles(), this));
                newThread.start();
                threads.add(newThread);
            }
        }
    }

    @Override
    public void run() {
        Searching(files);
        for (int i = 0; i < threads.size(); i++) {
            try {
                threads.get(i).join();
            }catch (NullPointerException e){
                e.getMessage();
            }catch (InterruptedException ignored) {
                ignored.getMessage();
            }
        }
        if (found.size() == 0) {
            System.out.println("Nothing was found!");
        } else {
            System.out.println();
            for (File i : found) {
                System.out.println(i.getAbsoluteFile());
            }
        }
    }
}
