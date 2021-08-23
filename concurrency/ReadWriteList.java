package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * ReadWriteList.java
 * This class demonstrates how to use ReadWriteLock to add concurrency
 * features to a non-thread safe collection
 * @author souvik sen
 */
public class ReadWriteList<T> {

    private List<T> list = new ArrayList<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public ReadWriteList(T... initialElements) {
        list.addAll(Arrays.asList(initialElements));
    }

    public void add(T element) {
        rwLock.writeLock().lock();
        try {
            list.add(element);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public T get(int index) {
        rwLock.readLock().lock();
        try {
            return list.get(index);
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public int size() {
        rwLock.readLock().lock();
        try {
            return list.size();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}