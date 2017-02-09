package company.shildt.chapter6;

/**
 * Created by OPER on 19.01.2017.
 */
public class Stack {
    private int stck[];
    private int tos;

    Stack(int sSize){
        if (sSize > 0){
            stck = new int[sSize];
            tos = -1;
        } else {
            throw new IllegalArgumentException("Размер стека должен быть больше нуля");
        }
    }

    boolean push(int val){
        if ((stck == null) || (tos == (stck.length - 1))){
           return false;
        }else{
            stck[++tos] = val;
            return true;
        }
    }

    int pop(){
        return (tos >= 0) ? stck[tos--] : Integer.MIN_VALUE;
    }
}


