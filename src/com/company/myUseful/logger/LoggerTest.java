package company.myUseful.logger;

import sun.util.logging.PlatformLogger;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    private static final Logger logger;
    private int[] arr;

    static {
        logger = Logger.getLogger("company.myUseful.logger");


        //По умолчанию регистратор и обработчик собирают сообщения уровня INFO и выше,
        //но явно задать уровень протоколирования для обоих (как показано ниже),
        //или необходимо поправить .level в конфигурационном файле jre/lib/logging.properties
        //или создать свой файл конфигурации и установить его

        logger.setLevel(Level.ALL);
        //logger.setLevel(Level.WARNING);
        //logger.setLevel(Level.INFO);
        logger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        
    }


    public LoggerTest() {
    }

    public static void main(String[] args) {
        logger.entering("company.myUseful.logger.LoggerTest", "main", args);

        logger.info("Create instance");
        LoggerTest instance = new LoggerTest();

        logger.info("Init array");
        instance.initArray();

        logger.info("Print array");
        instance.printArray();

        logger.exiting("company.myUseful.logger.LoggerTest", "main");

    }

    private void initArray() {
        logger.entering("company.myUseful.logger.LoggerTest", "initArray");
        int length;
        if (Math.random() > 0.5) {
            length = 20;
            logger.log(Level.FINEST, "Array size = 20. OK");
        } else {
            length = -20;

            IllegalArgumentException e = new IllegalArgumentException("Size of array = " + length);
            logger.throwing("company.myUseful.logger.LoggerTest", "initArray", e);
            throw e;

        }
        arr = new int[length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        logger.exiting("company.myUseful.logger.LoggerTest", "initArray");
    }

    private void printArray() {
        logger.entering("company.myUseful.logger.LoggerTest", "printArray");

        logger.info("Printing array");
        System.out.printf(Arrays.toString(arr));

        logger.exiting("company.myUseful.logger.LoggerTest", "printArray");
    }
}
