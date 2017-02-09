package company.shildt.chapter9;

/**
 * Created by dmitry on 08.02.17.
 */
interface MyIF {
    int getNumber();

    default String getString() {
        return "Объект типа String по умолчанию";
    }

    static int getDefaultNumber(){
        return 0;
    }
}

class MyIFImp implements MyIF {

    @Override
    public int getNumber() {
        return 100;
    }
}

class MyIFImp2 implements MyIF{

    @Override
    public int getNumber() {
        return 100;
    }

    @Override
    public String getString() {
        return "Это другая символьная строка";
    }
}

class DefaultMethodDemo {
    public static void main(String[] args) {
        MyIF obj = new MyIFImp();

        System.out.println(obj.getNumber());
        System.out.println(obj.getString());

        System.out.println();

        obj = new MyIFImp2();
        System.out.println(obj.getNumber());
        System.out.println(obj.getString());
    }
}
