package company.myUseful.myException;

import java.io.FileNotFoundException;

/**
 * Created by OPER on 26.04.2017.
 */
public class AutorizationException extends Exception {
    public AutorizationException(String s, FileNotFoundException e) {
        super(s, e);
    }
}
