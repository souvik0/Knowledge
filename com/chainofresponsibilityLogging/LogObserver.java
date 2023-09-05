package com.chainofresponsibilityLogging;

public interface LogObserver {

    public void updateObserver();
    public void setSubject(Logger logger);
}
