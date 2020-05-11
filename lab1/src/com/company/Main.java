package com.company;

import sun.awt.windows.ThemeReader;

public class Main {

    public static void main(String[] args) {
        int count = 15;
        Thread[] threads = new Thread[count];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread((new FactorialSolved(i+1)));
        }
        for(Thread thr: threads)
        {
            thr.start();
        }
    }
}
