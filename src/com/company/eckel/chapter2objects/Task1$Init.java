package company.eckel.chapter2objects;

public class Task1$Init {
    int x;
    char c; //по умолчанию инициализируется  '\u0000' - пустой символ

    public static void main(String[] args) {
        Task1$Init obj = new Task1$Init();
        System.out.println("x = " + obj.x);
        System.out.println("c = " + obj.c);

    }
}
