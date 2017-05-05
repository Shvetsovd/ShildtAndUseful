package company.myUseful.inheritance.example2;

interface IBuffer{
    int DEFAULT_SIZE = 256;
    int MAX_SIZE = (1<<31 - 1);

    default byte[] getBuffer(){
        return new byte[DEFAULT_SIZE];
    }
    static void fill(byte[] buf, byte value){
        for (int i = 0; i < buf.length; i++)
            buf[i] = value;
    }
    void copyTo(byte[] newBuf);
    void clear();
}

abstract class A {
    static {
        System.out.println("Static block Outer");
    }
    {
        System.out.println("Non-static block Outer");
    }
    public A(int a) {
        super();
        System.out.println("Outer(int a)");
    }
}

class B extends A {

    static {
        System.out.println("Static block B");
    }
    {
        System.out.println("Non-static block B");
    }
    B(){
        super(1);
        System.out.println("B()");
    }
}

class ABTest{
    static {
        System.out.println("Static block AB");
    }
    public static void main(String[] args) {
        B b = new B();
    }
}

