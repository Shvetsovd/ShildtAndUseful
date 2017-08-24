package company.eckel.containers;//: containers/StringHashCode.java

public class StringHashCode {
  public static void main(String[] args) {
    String[] hellos = "Hello Hello".split(" ");
    System.out.println(hellos[0].hashCode());
    System.out.println(hellos[1].hashCode());

    System.out.println(hellos[0] == hellos[1]);
    System.out.println(hellos[0] == "Hello");
    System.out.println(hellos[1] == "Hello");

  }
} /* Output: (Sample)
69609650
69609650
*///:~
