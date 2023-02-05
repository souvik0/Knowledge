package com.concurrency;

import java.util.Random;

public class Reader implements Runnable {
    private ReadWriteList<Integer> sharedList;

    public Reader(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    public void run() {
        Random random = new Random();
        int index = random.nextInt(sharedList.size());
        Integer number = sharedList.get(index);

        try {
            Thread.sleep(1000);
            System.out.println("-> get: " + number);
        } catch (InterruptedException ie ) { 
            ie.printStackTrace();
        }
     }
}