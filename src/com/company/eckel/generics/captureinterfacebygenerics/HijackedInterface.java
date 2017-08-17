package company.eckel.generics.captureinterfacebygenerics;//: generics/HijackedInterface.java
// {CompileTimeError} (Won't compile)

// Error: Comparable cannot be inherited with different arguments: <Cat> and <Pet>
class Cat extends ComparablePet /*implements Comparable<Cat>*/{
  public int compareTo(Cat arg) { return 0; }
} ///:~
