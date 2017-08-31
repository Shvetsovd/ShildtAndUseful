package company.useful.generics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by OPER on 22.03.2017.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stck = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String value;
            while (!((value = br.readLine())
                    .toLowerCase()
                    .equals("stop"))){
                stck.push(Integer.parseInt(value));
            }

            System.out.print("Stack elements: ");
            System.out.println(Arrays.toString(stck.getStackTrace()) + "<-Top");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
