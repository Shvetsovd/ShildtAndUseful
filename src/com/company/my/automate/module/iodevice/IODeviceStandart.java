package company.my.automate.module.iodevice;

import java.io.Console;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by user on 02.03.2018.
 */
public class IODeviceStandart extends IODeviceBase {
    public IODeviceStandart() {
        super(System.in, System.out);
    }

    @Override
    public void clear() {
        for (int i = 0; i < 50; i++) {
            super.write("");
        }
    }

    @Override
    public void closeIO() {

    }

    @Override
    public String toString() {
        return "IODeviceStandart{" +
                "input=System.in" +
                ", output=System.out"+
                '}';
    }
}
