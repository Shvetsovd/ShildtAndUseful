package company.useful.nestedInner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 05.05.2017.
 */
public class QuickOverride {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){
            @Override
            public String toString() {
                return "Hello!";
                //return super.toString();
            }
        };
    }
}
