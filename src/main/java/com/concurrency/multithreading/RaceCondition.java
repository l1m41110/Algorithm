package com.concurrency.multithreading;

class RaceCondition {

    public static void main(String[] args) throws InterruptedException {

        LongWrapper longWrapper = new LongWrapper(0L);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                longWrapper.incrementNumber();
            }
        };

        Thread[] threads = new Thread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Value = " + longWrapper.getNumber());

    }

//    public static void main(String[] args) throws InterruptedException {
//
//        LongWrapper longWrapper = new LongWrapper(0L);
//
//        Runnable runnable = () -> {
//            for (int i = 0; i < 1000; i++) {
//                longWrapper.incrementNumber();
//            }
//        };
//
//        Thread thread = new Thread(runnable);
//        thread.start();
//        thread.join();
//
//        System.out.println("Value = " + longWrapper.getNumber());
//
//    }

}

class LongWrapper {

    private final Object key = new Object(); //to fix race condition
    private long number;

    public LongWrapper(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void incrementNumber() {
//        number = number + 1; //RACE CONDITION OPERATION FROM DIFFERENT THREADS: read value when increment and copy to the same field

        //fix race condition
        synchronized (key) {
            number = number + 1;
        }
    }

}



