package com.chainofresponsibilityLogging;

public class FileLogger extends AbstractLogObservable implements Logger {

    public Logger nextLogger;
    public int level;

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    @Override
    public void logMessage(int logLevel, String message) {
        if (this.level <= logLevel){
            write(message);
        }
        if (nextLogger != null){
            nextLogger.logMessage(logLevel, message);
        }
    }

    @Override
    public void write(String message) {
        System.out.println("Standard File::Logger: " + message);
        notifyLogObserver();
    }

    @Override
    public void notifyLogObserver() {
        for (LogObserver logObserver : logObserverList) {
             logObserver.setSubject(this);
             logObserver.updateObserver();
        }
    }
}
