package company.my.automate.module.iodevice;

import java.io.*;

/**
 * Created by user on 02.03.2018.
 */
public abstract class IODeviceBase implements IODevice {
    protected BufferedReader input;
    protected BufferedWriter output;

    public IODeviceBase(InputStream input, OutputStream output) {
        this.input = new BufferedReader(new InputStreamReader(input));
        this.output = new BufferedWriter(new OutputStreamWriter(output));
    }

    @Override
    public String read() {
        String message = null;
        try {
            message = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public void write(String msg) {
        try {
            output.write(msg);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "IODeviceBase{" +
                "input=" + input +
                ", output=" + output +
                '}';
    }
}
