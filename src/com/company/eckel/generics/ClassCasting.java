package company.eckel.generics;//: generics/ClassCasting.java
import java.io.*;
import java.util.*;

public class ClassCasting {
  @SuppressWarnings("unchecked")
  public void f(String[] args) throws Exception {
    ObjectInputStream in = new ObjectInputStream(
      new FileInputStream(args[0]));
      // Won't Compile:
    //List<String> lw1 = List<String>.class.cast(in.readObject());
    List<String> lw2 = List.class.cast(in.readObject());
  }
} ///:~
