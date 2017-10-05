package company.ocajp1;

class Mock {
    public static void main(String[] args) {
        Mock mock = new Mock();
    }

}

class InitializationFuckBrainClass {
    static void print(int num) {
        System.out.print(num + " ");
    }

    static {
        print(0);
    }

    {
        print(1);
    }

    static {
        print(2);
        new InitializationFuckBrainClass();
    }

    {
        print(3);
    }

    public InitializationFuckBrainClass() {
        print(999);
    }

    {
        print(4);
    }

    static {
        print(5);
    }

    public static void main(String[] args) {
        System.out.println("Start...");
    } //0 2 1 3 4 999 5 Start...
}

