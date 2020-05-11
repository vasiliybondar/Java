package com.company;
import java.util.concurrent.Semaphore;


public class Philosoph extends Thread {
    private int id;
    private int num = 0;

    private  Semaphore semaphore;

    public Philosoph(int id, Semaphore semaphore) {
        this.id = id;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
            try {
                while (num < 3) {
                    semaphore.acquire();
                    System.out.format("Философ %s садится за стол %n", id);
                    sleep(500);
                    num++;

                    System.out.format("Философ %s отдыхает за столом %n", id);
                    sleep(500);
                    semaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
