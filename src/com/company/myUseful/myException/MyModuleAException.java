package company.myUseful.myException;

/**
 * Created by dmitry on 11.02.17.
 */
public class MyModuleAException extends MyApplicationException {

    private final static String moduleName = "Module A";


    public MyModuleAException() {
        super();
    }

    public MyModuleAException(String msg) {
        super(msg);
    }

    public MyModuleAException(Throwable cause) {
        super(cause);
    }

    public MyModuleAException(String msg, Throwable cause) {
        super(msg, cause);
    }


    @Override
    public String getErrorModuleName() {
        return moduleName;
    }

    @Override
    public String toString() {

        String msg = super.getMessage();
        Throwable cause = this.getCause();

        StringBuilder descr = new StringBuilder(moduleName);
        descr.append(": ");

        if (msg != null) {
            descr.append(msg);
            descr.append('.');
        }
        else {
            descr.append(" error. ");
        }

        if (cause != null){
            descr.append("\nПричина --> ");
            descr.append(cause.getClass());

            if (cause.getMessage() != null){
                descr.append(": ");
                descr.append(cause.getMessage());
            }
        }

        return descr.toString();
    }
}
