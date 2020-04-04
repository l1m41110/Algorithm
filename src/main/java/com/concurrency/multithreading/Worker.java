package com.concurrency.multithreading;

import java.util.Timer;
import java.util.TimerTask;

public class Worker extends Thread {

    private Object lock = new Object();
    private volatile boolean quittingTime = false;

    public void run() {
        while (!quittingTime) {
            working();
            System.out.println("Still working...");
        }

        System.out.println("Coffee is good");
    }

    private void working() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
        }
    }

    synchronized void quit() throws InterruptedException {
        synchronized (lock) {
            quittingTime = true;
            System.out.println("Calling join");
            join(); // thread blocked here on the join (the other one could take the key and synchronized keep working)
            System.out.println("Back from join");
        }
    }

    synchronized void keepWorking() {
        synchronized (lock) {
            quittingTime = false;
            System.out.println("Keep working");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final Worker worker = new Worker();
        worker.start();

        Timer timer = new Timer(true); // Daemon thread
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                worker.keepWorking();
            }
        }, 500);

        Thread.sleep(400);
        worker.quit();

    }

}

/*
    How to write correct concurrent code?
    - Check for race conditions
    - They occur on fields (not variables, inside methods/parameters)
    - more than 1 thread trying to read/write: race condition

    - Check for the happens-before link )between read and write operations
    - Are the read/write volatile?
    - Are they synchronized?
    - If not, there is a probably bug

    - Synchronized or volatile?
    - no simple answer
    - do I need atomicity in a certain portion of code that should not be interrupted: then need synchronized
    - if not, volatile = visibility is enough
 */
