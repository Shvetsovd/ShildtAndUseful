//: typeinfo/pets/ForNameCreator.java
package company.eckel.typeinfo.pets;
import java.util.*;

public class ForNameCreator extends PetCreator {
  private static List<Class<? extends Pet>> types =
    new ArrayList<Class<? extends Pet>>();
  // Types that you want to be randomly created:
  private static String[] typeNames = {
    "company.eckel.typeinfo.pets.Mutt",
    "company.eckel.typeinfo.pets.Pug",
    "company.eckel.typeinfo.pets.EgyptianMau",
    "company.eckel.typeinfo.pets.Manx",
    "company.eckel.typeinfo.pets.Cymric",
    "company.eckel.typeinfo.pets.Rat",
    "company.eckel.typeinfo.pets.Mouse",
    "company.eckel.typeinfo.pets.Hamster"
  };	
  @SuppressWarnings("unchecked")
  private static void loader() {
    try {
      for(String name : typeNames)
        types.add(
          (Class<? extends Pet>)Class.forName(name));
    } catch(ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  static { loader(); }
  public List<Class<? extends Pet>> types() {return types;}
} ///:~
