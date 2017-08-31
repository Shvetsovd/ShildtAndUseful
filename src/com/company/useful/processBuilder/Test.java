package company.useful.processBuilder;

import java.io.IOException;

/**
 * Created by OPER on 19.06.2017.
 */
public class Test {
    public static void main(String args[]) throws IOException, InterruptedException {
        //ProcessBuilder pb = new ProcessBuilder("c:\\Program Files\\CPUID\\HWMonitor\\HWMonitor.exe");
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");

        /*Map<String, String> env = pb.environment();
        for (Map.Entry s: env.entrySet()) {
            System.out.println(s.getKey() + " = " + s.getValue());
        }*/

        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);

        pb.start();


    }
}
