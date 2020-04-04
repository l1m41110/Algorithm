package com.concurrency.multithreading;

public class Singleton {
    private static final Object key = new Object();
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (key) {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }

}

/*
    Problems with this code:
    - read operation
    - write operation
    - if they occur in different thread ==> it is a RACE condition
    - no happens before link between them
    - NOT THREAD SAFE: 2 threads: 1 one create instance, 2 one overwritten, 1 one will have null instance.

    SOLUTIONS:
    - make the read and write synchronous
    - singleton in a single core CPU: 2 threads T1 and T2 calling getInstance():
        T1 first execute the method, T2, tries but key not available
        T1 has the key will finish getInstance()
        T2 has key, enter and getInstance() and read instance
    - singleton in a multicore CPU: T1, T2, T3:
        timeout when t2 tries to have the key and read, t1 finishes, t2 reads instance
        because more than 2 cores: performance issue: Racing condition: it cannot be made in parallel

    SOLUTION 2: once instance has been initialized, allow its reading in parallel
    - fix the race condition for multithread: double check locking singleton pattern: remove synchronized
    - this pattern is bugged!
    - because there is no happens before link between the read returning the value and the write that sets it
    - this bug is not visible in a single core CPU
    - this visibility issue is just on multicore CPU: because of difference caches on each core of the CPU

    SOLUTION 3: non-synchronized / volatile read
    
 */