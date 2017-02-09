package company.shildt.chapter7;

/**
 * Created by dmitry on 31.01.17.
 */
class Factorial {
    int fact(int n){
        if(n == 1) return 1;

        return fact(n -1) * n;
    }
}
class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("Факториал 3 равен " + f.fact(3));
        System.out.println("Факториал 4 равен " + f.fact(4));
        System.out.println("Факториал 5 равен " + f.fact(5));
    }
}
