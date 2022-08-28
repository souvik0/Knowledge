package com.concurrency;

import java.util.concurrent.Callable;

public class MultiplyingTask<Integer> implements Callable<Integer> {

    int a;
    int b;
    long sleepTime;
    String taskName;

    public MultiplyingTask(String taskName,int a, int b, long sleepTime) {
        this.taskName=taskName;
        this.a=a;
        this.b=b;
        this.sleepTime=sleepTime;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Started taskName: "+taskName);
        int result = a * b;
        Thread.sleep(sleepTime);
        System.out.println("Completed taskName: "+taskName);
        return result;
    }
}
