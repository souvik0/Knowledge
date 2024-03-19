package com.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<E> {

    private final Queue<E> queue;
    private final int capacity;

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized void put(E element) throws InterruptedException {
        while (queue.size() == capacity) {
            // Wait until space becomes available in the queue
            wait();
        }
        // Add element to the queue
        queue.offer(element);
        // Notify any waiting consumers that an element has been added
        notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        while (queue.isEmpty()) {
            // Wait until there are elements in the queue
            wait();
        }
        // Remove and return the element from the queue
        E element = queue.poll();
        // Notify any waiting producers that space is available in the queue
        notifyAll();
        return element;
    }

    public synchronized int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<>(5);

        // Producer thread
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    blockingQueue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int element = blockingQueue.take();
                    System.out.println("Consumed: " + element);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
