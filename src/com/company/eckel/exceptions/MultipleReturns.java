package company.eckel.exceptions;

//: exceptions/MultipleReturns.java

public class MultipleReturns {
    public static int f(int i) {
        System.out.println("f(i): Initialization that requires cleanup");
        try {
            System.out.println("Point 1");
            if(i == 1) return 1;
            System.out.println("Point 2");
            if(i == 2) return 2;
            System.out.println("Point 3");
            if(i == 3) return 3;
            System.out.println("End");
            return -1;
        } finally {
            System.out.println("Finally: Performing cleanup");
        }
    }
    public static void main(String[] args) {
        for(int i = 1; i <= 4; i++) {
            int result = f(i);
            System.out.println("f(" + i + ") return value: " + result);
            System.out.println("--------------------------------");
        }
    }
} /* Output:
Initialization that requires cleanup
Point 1
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
Performing cleanup
Initialization that requires cleanup
Point 1
Point 2
Point 3
End
Performing cleanup
*///:~

