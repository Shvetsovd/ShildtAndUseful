package company.shildt.chapter10;

/**
 * Created by dmitry on 11.02.17.
 */
class MyException extends Exception {
    MyException(){
        super();
    }
    MyException(String msg){
        super(msg);
    }
    MyException(String msg, Throwable cause){
        super(msg);
        this.initCause(cause);
    }
}

