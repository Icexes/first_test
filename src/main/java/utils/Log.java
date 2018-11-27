package utils;

import org.apache.log4j.Logger;

public class Log {

    //Initialize Log4j instance
    public static Logger Log = Logger.getLogger(Log.class.getName());

    //We can use it when starting tests
    public static void startLog(String testClassName) {
        Log.info("*********************************************************");
        Log.info("Test " + testClassName + " is Starting...");
        Log.info("*********************************************************");
    }

    //We can use it when ending tests
    public static void endLog() {
        Log.info("*********************************************************");
        Log.info("Test Ended...");
        Log.info("*********************************************************");
    }

    //Info Level Logs
    public static void info(String message) {
        Log.info(message);
    }

    //Warn Level Logs
    public static void warn(String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public static void error(String message) {
        Log.error(message);
    }

    //Fatal Level Logs
    public static void fatal(String message) {
        Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug(String message) {
        Log.debug(message);
    }
}