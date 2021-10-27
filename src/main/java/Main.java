import utils.FileLogger;

//This is where our program starts, with the main method and contains the menus and primary loop.
public class Main {
    public static void main(String[] args) {

        /*
        We're no longer starting here in Main (AKA Driver), instead our program execution is now controlled by
        our webserver, Smart Tomcat. Tomcat will start up and prepare our servlets, then when requests come in
        they will be dispatched to the appropriate servlet. We can do any start-up and tear-down logic we need
        in the DependencyLoaderListener class.
         */

        FileLogger.getFileLogger().console().threshold(0).writeLog("Here is our log file message", 0);


    }
}
