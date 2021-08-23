package concurrency;

import java.util.Random;

public class Writer implements Runnable{

    private ReadWriteList<Integer> sharedList;

    public Writer(ReadWriteList<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {

        Random random = new Random();
        int number = random.nextInt(100);
        sharedList.add(number);

        try {
            Thread.sleep(100);
            System.out.println("-> put: " + number);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}