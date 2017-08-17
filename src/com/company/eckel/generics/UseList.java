package company.eckel.generics;//: generics/UseList.java
// {CompileTimeError} (Won't compile)
import java.util.*;

public class UseList<W,T> {
  void f(List<T> v) {}

  //Compile error
  //void f(List<W> v) {}
} ///:~
