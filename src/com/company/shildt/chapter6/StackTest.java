package company.shildt.chapter6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by OPER on 19.01.2017.
 */
public class StackTest {
    public static void main(String[] args) throws IOException{

        System.out.print("Введите размерность стека:");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(bf.readLine());

        Stack myStack = new Stack(size);

        do{
            System.out.println("1. Push to stack");
            System.out.println("2. Pop from stack");
            System.out.println("3. Pop all values");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(bf.readLine());
            int value;
            switch(choice){
                case 1:
                    System.out.print("Push value:");
                    value = Integer.parseInt(bf.readLine());
                    if(!myStack.push(value)){
                        System.out.println("Невозможно внести значение в стек!");
                    }
                    break;
                case 2:
                    System.out.print("Pop value:");
                    System.out.println(myStack.pop());
                    break;
                case 3:
                    value = myStack.pop();
                    while(value != Integer.MIN_VALUE){
                        System.out.println(value);
                        value = myStack.pop();
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Incorrect choice!");
            }
        }while(true);

    }
}
