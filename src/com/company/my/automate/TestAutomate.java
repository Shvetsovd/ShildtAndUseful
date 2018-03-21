package company.my.automate;

import company.my.automate.base.Automate;
import company.my.automate.base.StringHolderAutomate;
import company.my.automate.base.exception.AutomateException;
import company.my.automate.module.box.StringBox;
import company.my.automate.module.iodevice.IODeviceStandart;

/**
 * Created by user on 02.03.2018.
 */
public class TestAutomate {
    public static void main(String[] args) {
        Automate<String> automate = new StringHolderAutomate(new IODeviceStandart(), 4, 777);
        automate.start();
    }
}
