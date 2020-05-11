package com.company;

public class Main {

    public static void main(String[] args) {

        Dock dock1 = new Dock("Dock #1");
        Dock dock2 = new Dock("Dock #2");
        Ship ship1 = new Ship("Ship #1", dock1, dock2);
        Ship ship2 = new Ship("Ship #2", dock1, dock2);
        Ship ship3 = new Ship("Ship #3", dock1, dock2);
    }
}
