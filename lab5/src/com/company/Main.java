package com.company;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        for (int i = 1; i < 6; i++){
            new Philosoph(i, semaphore).start();
        }

    }
}
