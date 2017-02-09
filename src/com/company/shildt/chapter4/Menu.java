package company.shildt.chapter4;

/**
 * Created by user on 17.01.2017.
 */

public class Menu {
    public static void main(String[] args) throws java.io.IOException{
        char choice;
        do {
            System.out.println("Справка по оператору:");
            System.out.println("\t1. if");
            System.out.println("\t2. switch");
            System.out.println("\t3. while");
            System.out.println("\t4. do-while");
            System.out.println("\t5. for\n");
            System.out.print("Выберите нужный пункт:");
            choice = (char)System.in.read();
        }while(choice < '1' || choice > '5');

        System.out.println("\n");

        switch (choice){
            case '1':
                System.out.println("if\n");
                System.out.println("if(условие) оператор;");
                System.out.println("else оператор;");
                break;
            case '2':
                System.out.println("switch:\n");
                System.out.println("switch(выражение) {");
                System.out.println(" case константа:");
                System.out.println(" последовательность операторов");
                System.out.println(" break;");
                System.out.println(" // ...");
                System.out.println("}");
                break;
            case '3':
                System.out.println("while:\n");
                System.out.println("while(условие) оператор;");
                break;
            case '4':
                System.out.println("do-while:\n");
                System.out.println("do {");
                System.out.println("\tоператор;");
                System.out.println("} while (условие);");
                break;
            case '5':
                System.out.println("for:\n");
                System.out.println("for(инициализация; условие; итерация)");
                System.out.println("\tоператор;");
                break;
        }
    }
}
