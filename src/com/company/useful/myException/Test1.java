package company.useful.myException;

/**
 * Created by OPER on 26.04.2017.
 */
public class Test1 {
    public static void main(String[] args) throws Exception {
        try{
         Exception ex = new RuntimeException();
         throw ex;
        } catch (RuntimeException e){

        }
    }
}
