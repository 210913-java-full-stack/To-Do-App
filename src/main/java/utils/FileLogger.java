package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
<<<<<<< HEAD
    //print some or all of the stack trace to file
    //logging levels - Severe, moderate, warming, info

    private static FileLogger fileLogger;
    private static int threshold;
    private static boolean printToConsole;
    private static boolean printToConsoleTemp = false;
=======
    private static FileLogger fileLogger;
    private static int threshold; //would like to enumerate thresholds and devise something that checks inequality
    private static boolean printToConsole;
    private static boolean printToConsoleTemp;
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66

//    public enum Threshold {
//        INFO,
//        WARN,
//        MODERATE,
//        SEVERE
//    }

    private FileLogger() {
        printToConsole = false;
        printToConsoleTemp = false;
        threshold = 3;
<<<<<<< HEAD

    }

    public static FileLogger getFileLogger() {
        if(fileLogger == null) {
        fileLogger = new FileLogger();
    }
        return fileLogger;
}


    public void writeLog(String message, int level) {
        try (FileWriter fileWriter = new FileWriter(getLogFileName(), true)){
=======
    }

    public static FileLogger getFileLogger(){
        if(fileLogger == null) {
            fileLogger = new FileLogger();
        }
        return fileLogger;
    }

    public void writeLog(String message, int level) {
        try (FileWriter fileWriter = new FileWriter(getLogFileName(), true)){//try-with-resources block, filewriter will auto-close
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
            String logEntry = formatLogEntry(message);

            if(level >= threshold) {
                fileWriter.write(logEntry);
<<<<<<< HEAD
            }

            if(printToConsole|| printToConsoleTemp) {
                System.out.println(logEntry);
                printToConsoleTemp = false;
=======
                }

            if(printToConsole || printToConsoleTemp) {
                System.out.println(logEntry);
                printToConsoleTemp = false;

>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getLogFileName() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
<<<<<<< HEAD
        return "logs/" + today + "log";
    }

    private String formatLogEntry(String message) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s [%s] %s", timeStamp, stackInfo, message);
=======
        return today + ".log";
    }

    private String formatLogEntry(String message){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s  [%s]  %s%n", timestamp, stackInfo, message);
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
    }

    public FileLogger console() {
        printToConsoleTemp = true;
        return fileLogger;
    }

    public FileLogger threshold(int th) {
        threshold = th;
        return fileLogger;
    }

<<<<<<< HEAD
//    private boolean checkThreshold(Threshold level) {
//
//    }
=======
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
    public static boolean isPrintToConsole() {
        return printToConsole;
    }

    public static void setPrintToConsole(boolean printToConsole) {
        FileLogger.printToConsole = printToConsole;
    }

<<<<<<< HEAD

=======
>>>>>>> 31e7d02c7d0ecf7d68b6c65cc8ee2a1562c8ec66
    public static int getThreshold() {
        return threshold;
    }

    public static void setThreshold(int threshold) {
        FileLogger.threshold = threshold;
    }
}
