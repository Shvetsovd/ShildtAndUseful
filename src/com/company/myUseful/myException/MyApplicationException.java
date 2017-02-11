package company.myUseful.myException;

/**
 * Created by dmitry on 11.02.17.
 */
public abstract class MyApplicationException extends Exception {

    public abstract String getErrorModuleName();

    protected MyApplicationException() {
        super();
    }

    protected MyApplicationException(String msg) {
        super(msg);

    }

    protected MyApplicationException(String msg, Throwable cause) {
        super(msg, cause);

    }

}

