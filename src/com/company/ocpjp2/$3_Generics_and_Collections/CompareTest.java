package company.ocpjp2.$3_Generics_and_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by user on 29.03.2018.
 */
public class CompareTest {

    public static void main(String[] args) {
        class Rabbit {
            private int id;
            Rabbit(int id) {this.id = id;}
            @Override
            public String toString() {return "Rabbit{" + "id=" + id + '}';}
        }
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(2));
        rabbits.add(new Rabbit(1));
        //Collections.sort(rabbits); // DOES NOT COMPILE

        Collections.sort(rabbits, (r1, r2) -> r1.id - r2.id);
        System.out.println(rabbits); //[Rabbit{id=1}, Rabbit{id=2}]

        Collections.sort(rabbits, (r1, r2) -> r2.id - r1.id);
        System.out.println(rabbits); //[Rabbit{id=2}, Rabbit{id=1}]
    }
}
