package company.eckel.polymorph;

class A {
    void meth(){
        System.out.println("A.meth()");
    }
}

class B extends A {

    void meth(){
        System.out.println("B.meth()");
    }
    public static void main(String[] args) {
        A a = new B();
        a.meth();
    }
}
