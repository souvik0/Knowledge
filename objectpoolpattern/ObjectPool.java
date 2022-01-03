package objectpoolpattern;

import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
// Here it is creating JDBC connection object connection object pool
public abstract class ObjectPool<T> {

    private long expirationTime;
    private Map<T, Long> locked; // Use this map to keep object right after creation & while using
    private Map<T, Long> unlocked; // Use this map to keep object after usage till expiration while not using

    // abstract methods
    public abstract T createConnection();
    public abstract boolean validate(T obj);
    public abstract void expire(T obj);

    public ObjectPool() {
        expirationTime = 30000; // 30 seconds
        locked = new HashMap<T, Long>();
        unlocked = new HashMap<T, Long>();
    }

    public synchronized T getObject() {
        long now = Instant.now().toEpochMilli();
        T t;
        // Checking if already any idol object exist or not & not used at this instance of time
        if (unlocked.size() > 0) {
            Iterator<T> itr = unlocked.keySet().iterator();
            while (itr.hasNext()) {
                t = itr.next();
                // if object age is greater than expiration time
                if ((now - unlocked.get(t)) > expirationTime) {
                    // object has expired
                    unlocked.remove(t);
                    expire(t);
                    t = null;
                } else {
                    if (validate(t)) {
                        unlocked.remove(t);
                        locked.put(t, now);
                        return t;
                    } else {
                        // object failed validation
                        unlocked.remove(t);
                        expire(t);
                        t = null;
                    }
                }
            }
        }
        // objects not available, create a new one for the first time
        t = createConnection();
        locked.put(t, now);
        return t;
    }

    // After using releasing the object to keep in safe backup in unlocked map for further use
    public synchronized void releaseObject(T obj) {
        locked.remove(obj);
        unlocked.put(obj, Instant.now().toEpochMilli());
    }
}