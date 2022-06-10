package com.singleton;
// Enum iS also by default singleton. Limitation is it always creates only one Object without Lazy loading
// Enum constructors are handled by JVM to create object.

// This class shows singleton object creation method by Lazy instantiation & Bill Pugh approach
// This implements Reflection. Serialization & clone proofing along with thread safety
import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // Singleton object needs to be volatile so that it can be at the main memory
    private static volatile Singleton eagerInstance = new Singleton();
    private static volatile Singleton lazyInstance = null; // Thread reads Singleton objects always from main memory

    // Default private constructor
    private Singleton() {
        // Reflection Proofing
        if (lazyInstance != null) {
            throw new RuntimeException("Prventing object created by reflection");
        }
    }

    // This will work if early instance created. Otherwise it will return null
    public static Singleton getSingletonEagerInstance() {
        return eagerInstance;
    }

    // Lazy Instantiation with Double checking thread safety implemented
    public static Singleton getSingletonLazyInstance() {
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
        return getSingletonLazyInstance();
    }

    // Implementation of BillPugh singleton
    private static class LazyHolder {
        public static final Singleton INSTANCE = new Singleton();
    }

    // Static factory instance method. Here it is referring BillPugh
    public static Singleton getLazyHolderInstance() {
        return LazyHolder.INSTANCE;
    }
}
