package company.useful.tmp.inheritance;

import company.useful.inheritance.Parent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by OPER on 04.04.2017.
 */
public class ChildInAnotherPackage extends Parent{
    public ChildInAnotherPackage() {
        this.pubInt = 0;
        this.protInt = 0;
        //this.defInt = 0; // compile error
        //this.privInt = 0; // compile error

        this.pubMethod();
        this.protMethod();
        //this.defMethod(); // compile error
        //this.privMethod(); // compile error

    }

    private void method(){
        Parent parent;

        ChildInAnotherPackage child = new ChildInAnotherPackage();
        child.pubInt = 0;
        child.protInt = 0;

        parent = child;
        parent.pubInt = 0;
        //parent.protInt = 0; // compile error


        //this.pubInt = 3;
        //super.pubInt = 5;

        //System.out.println("super.pubInt = " + super.pubInt + " this.pubInt = " + child.protInt);
    }

    public static void main(String[] args) {

        ChildInAnotherPackage child = new ChildInAnotherPackage();
        child.method();
        Field fields[] = child.getClass().getFields();
        System.out.println("Fields:");
        for (Field f: fields){
            System.out.println("\t" + f.getName());
        }

        Method methods[] = ChildInAnotherPackage.class.getMethods();
        System.out.println("Methods:");
        for(Method m: methods){
            System.out.println("\t"+m.getName());
        }


    }
}

