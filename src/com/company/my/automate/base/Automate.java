package company.my.automate.base;

import company.my.automate.base.exception.AutomateException;
import company.my.automate.module.box.Box;

/**
 * Created by user on 02.03.2018.
 */
public interface Automate<T> {
    void start();
    int put(T object, Box<T> box) throws AutomateException;
    T get(int code) throws AutomateException;
}
