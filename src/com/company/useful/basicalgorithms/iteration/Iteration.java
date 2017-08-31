package company.useful.basicalgorithms.iteration;

/**
 * Created by OPER on 19.04.2017.
 */
public class Iteration {
    public static void main(String[] args) {
        //example1();
        //example2();
        //example3();
        //example4();
        example5();
        //example6();
    }

    private static void example1() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    private static void example2() {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    private static void example3() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
    }

    private static void example4() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i > j) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }

    private static void example5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < j) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }

    private static void example6() {
        for (int i = 0; i < 5; i++) {
            System.out.print("0");
            for (int j = 0; j < 5; j++) {
                if (i < j) {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }

}
