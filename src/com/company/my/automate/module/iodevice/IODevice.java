package company.my.automate.module.iodevice;

import java.io.IOException;

/**
 * Created by user on 02.03.2018.
 */
public interface IODevice {
    String read();
    void write(String msg);

    void clear();
    void closeIO();
}
