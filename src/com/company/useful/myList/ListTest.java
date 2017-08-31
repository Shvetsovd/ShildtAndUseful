package company.useful.myList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by OPER on 23.01.2017.
 */
public class ListTest {
    public static void main(String[] args) {

            LinkedList list = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            do {
                try {
                    System.out.println("1. Insert to end");
                    System.out.println("2. Print list");
                    System.out.println("3. Delete list");
                    System.out.println("4. Exit");
                    System.out.println("________________");
                    System.out.print("Choice:");
                    int choice = Integer.parseInt(reader.readLine());
                    switch (choice){
                        case 1:
                            System.out.print("Value:");
                            if(list == null){
                                list = new LinkedList(Integer.parseInt(reader.readLine()));
                            }else {
                                list.insertToEnd(Integer.parseInt(reader.readLine()));
                            }
                            break;
                        case 2:
                            System.out.println(Arrays.toString(list.getAllValues()));
                            reader.readLine();
                            break;
                        case 3:
                            list.deleteList(LinkedList.DeleteMethod.RECURSE);
                            break;
                        case 4:
                            return;
                        default:
                            System.out.println("Try again!");
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("Error: " + e.getMessage().toLowerCase() + "\nTry again!");
                }
            }while (true);
    }
}
