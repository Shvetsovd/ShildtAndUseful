package company.myUseful.lambda;

import java.util.function.UnaryOperator;

/**
 * Created by OPER on 01.04.2017.
 */

public class Test2 {

    static<T> T stringOperations(T str, UnaryOperator<T> f) {
        return f.apply(str);
    }

    public static void main(String[] args) {
        MyClazz obj = new MyClazz();
        String resStr = stringOperations("123", obj::strToUpperCase2);
        obj = stringOperations(new MyClazz(), MyClazz::strToUpperCase3);



    }
}

class MyClazz{

    UnaryOperator<String> strReverse = (s) -> "123"; //количество параметров = их количеству в ф.и.

    static String strToUpperCase(String str) {return "123";} // f = MyClass::strToUpperCase


// в нестатических методах используется либо полная сигнатура ф.интерфейса, либо на 1 параметр // меньше (в качестве первого параметра будет вызывающий объект)


    String strToUpperCase2(String str) {return "123";} // f = obj::strToLowerCase ~ (s)->{strToUpperCase(s)}

    MyClazz strToUpperCase3() {return new MyClazz();} // f = MyClass::strToUpperCase ~ ()->{this.strToUpperCase()}

}
