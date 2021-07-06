package com.concurrency;

public class ReadWriteLockTest {

    public static final int READER_SIZE = 10;
    public static final int WRITER_SIZE = 2;

    public static void main(String[] args) {
        Integer[] initialElements = {33, 28, 86, 99};

        ReadWriteList<Integer> sharedList = new ReadWriteList<>(initialElements);

        for (int i = 0; i < WRITER_SIZE; i++) {
            new Thread(new Writer(sharedList)).start();
        }

        for (int i = 0; i < READER_SIZE; i++) {
            new Thread(new Reader(sharedList)).start();
        }
    }
}