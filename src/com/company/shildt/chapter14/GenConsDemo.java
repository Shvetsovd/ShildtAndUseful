package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class GenCons {
    private double val;

    <T extends Number>GenCons(T arg){
        val = arg.doubleValue();
    }

    void showValue(){
        System.out.println("val: " + val);
    }
}

public class GenConsDemo {
    public static void main(String[] args) {
        GenCons test = new GenCons(100);
        GenCons test2 = new GenCons(123.5F);

        test.showValue();
        test2.showValue();

    }
}
