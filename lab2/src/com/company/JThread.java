package com.company;

public class JThread extends Thread {
    private int[] a;
    public JThread(String name, int[] a) {
        super(name);
        this.a = a;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
    }


}
