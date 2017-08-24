package company.eckel.containers;//: containers/Lists.java
// Things you can do with Lists.

import java.util.*;

public class IteratorOperations {
  private static boolean b;
  private static String s;
  private static int i;
  private static Iterator<String> it;
  private static ListIterator<String> lit;

  public static void iterMotion(List<String> a) {
    ListIterator<String> it = a.listIterator();
    b = it.hasNext();
    b = it.hasPrevious();
    s = it.next();
    i = it.nextIndex();
    s = it.previous();
    i = it.previousIndex();
  }
  public static void iterManipulation(List<String> a) {
    ListIterator<String> it = a.listIterator();
    it.add("47");
    // Must move to an element after add():
    System.out.println(it.next());
    // Remove the element after the newly produced one:
    //it.remove();
    // Must move to an element after remove():
    //System.out.println(it.next());
    // Change the element after the deleted one:
    //it.set("47");
  }
  public static void main(String[] args) {

    List<String> list = new ArrayList<String>(Countries.names(5));
    iterManipulation(list);
    System.out.println(list);

  }
} /* (Execute to see output) *///:~
