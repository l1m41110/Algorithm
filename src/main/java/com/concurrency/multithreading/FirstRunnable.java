package com.concurrency.multithreading;

public class FirstRunnable {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            System.out.println("Running in " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);

        thread.setName("Thread 1");

        thread.start();
//        thread.run(); //Run inside thread main not thread created

    }
}
