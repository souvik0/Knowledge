package com.chainofresponsibilityLogging;

public class LoggingChain {

   private static Logger getChainOfLoggers(){
       FileLogger fileLogger = new FileLogger();
       ConsoleLogger consoleLogger = new ConsoleLogger();

       fileLogger.setNextLogger(consoleLogger);
       return fileLogger;
   }

    public static void main(String[] args) {
        Logger logger = getChainOfLoggers();
        logger.logMessage(LogLevel.INFO, "This is an information");
        logger.logMessage(LogLevel.DEBUG, "This is a Debug information");
        logger.logMessage(LogLevel.ERROR, "This is a information");
    }
}
