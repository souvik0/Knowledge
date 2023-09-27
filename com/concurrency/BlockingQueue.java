package com.concurrency;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<E> {

    private List<E> queue = new LinkedList<E>();
    private int limit;

    public BlockingQueue(int limit){
        this.limit = limit;
    }

    // Simulation of put operation
    public synchronized void enqueue(E item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }
        if (this.queue.size() < this.limit) {
            queue.add(item);
            notifyAll();
        }
    }

    // Simulation of get operation
    public synchronized E dequeue() throws InterruptedException {
        E item = null;
        while (this.queue.size() == 0){
            wait();
        }
        if (this.queue.size() > 0){
            item = this.queue.remove(0); // Queue follows FIFO
            notifyAll();
        }
        return item;
    }
}
