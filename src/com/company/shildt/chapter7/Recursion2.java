package company.shildt.chapter7;

/**
 * Created by dmitry on 31.01.17.
 */
class RecTest{
    int values[];

    public RecTest(int i) {
        values = new int[i];
    }

    void printArray(int n){
        if (n == 0) return;
        printArray(n -1);

        System.out.println("[" + (n-1) + "] " + values[n -1]);
    }
}
class Recursion2 {
    public static void main(String[] args) {
        RecTest ob = new RecTest(10);

        for (int i = 0; i < 10; i++) ob.values[i] = i;

        ob.printArray(10);
    }
}
