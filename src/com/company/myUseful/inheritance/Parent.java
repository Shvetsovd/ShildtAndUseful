package company.myUseful.inheritance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by OPER on 04.04.2017.
 */
public class Parent {
    public int pubInt;
    protected int protInt;
    int defInt;
    private int privInt;

    public void pubMethod(){}
    protected void protMethod(){}
    void defMethod(){}
    private void privMethod(){}
}

class ChildInPackage extends Parent{
    public ChildInPackage() {
        this.pubInt = 0;
        this.protInt = 0;
        this.defInt = 0;
        //this.prvInt = 0; // compile error

        pubMethod();
        protMethod();
        defMethod();
        //privMethod(); // compile error
    }

    public void method(){
        Parent parent;

        ChildInPackage child = new ChildInPackage();
        child.pubInt = 0;
        child.protInt = 0;
        child.defInt = 0;


        parent = child;
        parent.pubInt = 0;
        parent.protInt = 0;
        parent.defMethod();

    }

    public static void main(String[] args) {
        ChildInPackage child = new ChildInPackage();
        child.method();
        Field fields[] = child.getClass().getDeclaredFields();
        System.out.println("Fields:");
        for (Field f: fields){
            System.out.println("\t" + f.getName());
        }

        Method methods[] = ChildInPackage.class.getMethods();
        System.out.println("Methods:");
        for(Method m: methods){
            System.out.println("\t"+m.getName());
        }
    }
}
