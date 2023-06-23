package com.chainofresponsibilityLogging;

public class LoggingChain {

   private static FileLogger getChainOfLoggers(int logLevel){
       if (logLevel == LogLevel.INFO) {
           FileLogger fileInfoLogger = new FileLogger(LogLevel.INFO);
           ConsoleLogger consoleInfoLogger = new ConsoleLogger(LogLevel.INFO);
           Splunk splunk = new Splunk();

           fileInfoLogger.setNextLogger(consoleInfoLogger);
           consoleInfoLogger.setNextLogger(null);

           fileInfoLogger.registerLogObserver(splunk);
           return fileInfoLogger;
       }

       if (logLevel == LogLevel.DEBUG) {
           FileLogger fileDebugLogger = new FileLogger(LogLevel.DEBUG);
           ConsoleLogger consoleDebugLogger = new ConsoleLogger(LogLevel.DEBUG);
           Kivana kivana = new Kivana();

           fileDebugLogger.setNextLogger(consoleDebugLogger);
           consoleDebugLogger.setNextLogger(null);

           fileDebugLogger.registerLogObserver(kivana);
           return fileDebugLogger;
       }

       if (logLevel == LogLevel.ERROR) {
           FileLogger fileErrorLogger = new FileLogger(LogLevel.ERROR);
           ConsoleLogger consoleErrorLogger = new ConsoleLogger(LogLevel.ERROR);

           Splunk splunk = new Splunk();
           Kivana kivana = new Kivana();

           fileErrorLogger.registerLogObserver(splunk);
           consoleErrorLogger.registerLogObserver(kivana);

           fileErrorLogger.setNextLogger(consoleErrorLogger);
           consoleErrorLogger.setNextLogger(null);
           return fileErrorLogger;
       }

       return null;
   }

    public static void main(String[] args) {
        Logger infoLogger = getChainOfLoggers(LogLevel.INFO);
        infoLogger.logMessage(LogLevel.INFO, "This is an information");

        Logger debugLogger = getChainOfLoggers(LogLevel.DEBUG);
        debugLogger.logMessage(LogLevel.DEBUG, "This is a Debug information");

        Logger errorLogger = getChainOfLoggers(LogLevel.ERROR);
        errorLogger.logMessage(LogLevel.ERROR, "This is an Error information");
    }
}
