package company.ocpjp2.$8_IO;

import java.io.*;

/**
 * Created by user on 31.03.2018.
 */
public class BasicTests implements Serializable{
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null){
            throw new RuntimeException("Console is not available");
        }
    }
}
