package com.company;

public class Ship extends Thread {
    private Dock dock1;
    private Dock dock2;
    private Thread thr;

    public Ship(String name, Dock dock1, Dock dock2) {
        this.dock1 = dock1;
        this.dock2 = dock2;
        thr = new Thread(this);
        thr.setName(name);
        thr.start();
    }

    @Override
    public void run() {
        while (!dock1.isFree() & !dock2.isFree()) {
            try {
                synchronized (dock2) {
                    System.out.println(this.getThr().getName() + " is waiting for its turn.");
                    dock2.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (dock1.isFree()) {
            useDock(dock1);
        } else {
            useDock(dock2);
        }
    }

    private synchronized void useDock(Dock dock) {
        dock.setFree(false);
        System.out.println(thr.getName() + " has started to unload boxes at the " + dock.getName());

        for (int boxes = 10; boxes != 0; boxes--) {
            System.out.println("Box #" + boxes + " was unloaded by " + thr.getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dock.setFree(true);
        synchronized (dock) {
            dock.notify();
        }
    }

    public Thread getThr() {
        return thr;
    }
}
