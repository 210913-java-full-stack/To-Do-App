package utils;

import org.mariadb.jdbc.internal.com.read.resultset.SelectResultSet;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    //print some or all of the stack trace to file
    //logging levels - Severe, moderate, warming, info

    private static FileLogger fileLogger;
    private static int threshold;
    private static boolean printToConsole;
    private static boolean printToConsoleTemp = false;

    public enum Threshold {
        INFO,
        WARN,
        MODERATE,
        SEVERE
    }

    private FileLogger() {
        printToConsole = false;
        printToConsoleTemp = false;
        //threshold = Threshold.MODERATE;

    }

    public static FileLogger getFileLogger() {
        if(fileLogger == null) {
        fileLogger = new FileLogger();
    }
        return fileLogger;
}


    public void writeLog(String message, int level) {
        try (FileWriter fileWriter = new FileWriter(getLogFileName(), true);){
            String logEntry = formatLogEntry(message);

            if(level > threshold) {
                fileWriter.write(logEntry);
            }

            //TODO: Write logging level filtering logic here

            fileWriter.write(logEntry);

            if(printToConsole) {
                System.out.println(logEntry);
                printToConsole = false;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getLogFileName() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return today + "log";
    }

    private String formatLogEntry(String message) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[2].toString();
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s [%s] %s", timeStamp, stackInfo, message);
    }

    public FileLogger console() {
        printToConsoleTemp = true;
        return fileLogger;
    }

    public FileLogger threshold(int th) {
        threshold = th;
        return fileLogger;
    }

//    private boolean checkThreshold(Threshold level) {
//
//    }
    public static boolean isPrintToConsole() {
        return printToConsole;
    }

    public static void setPrintToConsole(boolean printToConsole) {
        FileLogger.printToConsole = printToConsole;
    }


    public static int getThreshold() {
        return threshold;
    }

    public static void setThreshold(int threshold) {
        FileLogger.threshold = threshold;
    }
}
