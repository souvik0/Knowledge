package com.singleton;
/* Enum is also by default singleton.
 * Limitation is it always creates only one Object without Lazy loading
 * Enum constructors are handled by JVM to create object.
 * This class shows singleton object creation method by Lazy instantiation & Bill Pugh approach
 * This implements Reflection. Serialization & clone proofing along with thread safety
 */

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // Singleton object needs to be volatile so that it can be at the main memory
    private static volatile Singleton eagerInstance = new Singleton();

    // This will work if early instance created. Otherwise it will return null
    public static Singleton getEagerInstance() {
        return eagerInstance;
    }

    private static volatile Singleton lazyInstance = null; // Thread reads Singleton objects always from main memory

    // Default private constructor
    private Singleton() {
        // Reflection Proofing
        if (lazyInstance != null || eagerInstance != null) {
            throw new RuntimeException("Prventing object created by reflection");
        }
    }

    // Lazy Instantiation with Double checking thread safety implemented
    public static Singleton getLazyInstance() {
        if (lazyInstance == null) {
            synchronized(Singleton.class) {
                // Introducing double checking
                if (lazyInstance == null) {
                    lazyInstance = new Singleton();
                }
            }
        }
        return lazyInstance;
    }

    // Clone Proofing
    public Singleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    // Serialization Proofing
    protected Singleton readResolve() {
        return getLazyInstance();
    }
}
