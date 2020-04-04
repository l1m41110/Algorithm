package com.concurrency.multithreading;

public class DeadLock {

    public Object key1 = new Object();
    public Object key2 = new Object();

    public void a() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            System.out.println("[" + Thread.currentThread().getName() + "] I am in c()");
        }
    }

}

class RunningDeadLock {

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock = new DeadLock();

        Runnable runnable1 = () -> deadLock.a();
        Runnable runnable2 = () -> deadLock.b();

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
