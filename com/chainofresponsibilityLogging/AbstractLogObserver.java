package com.chainofresponsibilityLogging;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractLogObserver {

    List<LogObserver> logObserverList = new ArrayList<LogObserver>();

    public void registerLogObserver(LogObserver logObserver) {
        logObserverList.add(logObserver);
    }

    public void deRegisterLogObserver(LogObserver logObserver) {
        logObserverList.remove(logObserver);
    }

    public abstract void notifyLogObserver();
}
