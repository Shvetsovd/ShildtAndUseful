package company.my.automate.base;

import company.my.automate.module.box.Box;
import company.my.automate.module.box.StringBox;
import company.my.automate.module.iodevice.IODevice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by user on 02.03.2018.
 */
public class StringHolderAutomate extends AutomateBase<String> {
    public StringHolderAutomate(IODevice ioDevice, int numberOfBoxes, int masterKey) {
        super(ioDevice, numberOfBoxes, masterKey);

        boxes = new ArrayList<>();
        for (int i = 1; i <= numberOfBoxes; i++) {
            boxes.add(new StringBox(i));

        }
        boxes = Collections.unmodifiableList(boxes);
    }

    @Override
    protected String getUserObject() {
        return io.read();
    }
}
