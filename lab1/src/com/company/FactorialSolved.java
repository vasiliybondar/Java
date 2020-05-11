    package com.company;

    public class FactorialSolved implements Runnable {
        int id;
        public FactorialSolved(int i) {
        this.id = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "  -  " + solve(id));
        }

        int solve(int n)
        {
            return ((n>1)? n* solve(n-1):1);
        }
    }

