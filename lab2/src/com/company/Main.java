package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int Arr[] = new int[2000000];
        int sum = 0;

        Random rnd = new Random();

        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = (rnd.nextInt(10) + 1);
        }

        long start = System.currentTimeMillis();
        for (int i = 1; i < 10; i++) {
            new JThread("JThread " + i, Arr).start();
        }

        long finish = System.currentTimeMillis();
        System.out.println("Threads time:" + (finish - start) + " miliseconds");

        start = System.currentTimeMillis();


        for (int i = 0; i < Arr.length; i++)
        {
            sum += Arr[i];
        }

        finish = System.currentTimeMillis();
        System.out.println("Simple time:" + (finish - start) + " miliseconds");
    }
}
