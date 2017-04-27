package company.myUseful.myException;

import java.io.FileNotFoundException;

/**
 * Created by OPER on 26.04.2017.
 */
public class Translation {
    public static void method() throws AutorizationException {
        try{
            throw new FileNotFoundException();
        } catch (FileNotFoundException e){
            throw new AutorizationException("Unable check user account", e);
        }
    }
}
