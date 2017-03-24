package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class GenArr<T extends Number> {
    T ob;
    T vals[];

    GenArr(T o, T[] nums) {
        this.ob = ob;
        //vals = new T[10]; //Error
        vals = nums;
    }
}

public class GenArrays {
    public static void main(String[] args) {
        Integer n[] = {1, 2, 3, 4, 5};

        GenArr<Integer> iOb = new GenArr<>(50, n);

        //GenArr<Integer> gens[] = new GenArr<Integer>[10]; //Error

        GenArr<?> gens[] = new GenArr<?>[10]; //Ok
    }
}
