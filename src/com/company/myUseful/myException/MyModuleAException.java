package company.myUseful.myException;

/**
 * Created by dmitry on 11.02.17.
 */
public final class MyModuleAException extends MyApplicationException {


    private final static String moduleName = "Module A";

    public MyModuleAException() {
        super();
    }

    public MyModuleAException(String msg) {
        super(msg);
    }

    public MyModuleAException(String msg, Throwable cause) {
        super(msg, cause);
    }

    @Override
    public String getErrorModuleName() {
        return moduleName;
    }
}
