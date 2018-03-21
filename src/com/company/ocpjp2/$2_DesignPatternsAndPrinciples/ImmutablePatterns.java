package company.ocpjp2.$2_DesignPatternsAndPrinciples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.03.2018.
 */
final class Animal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

    public List<String> getFavoriteFoods(){
        return new ArrayList<>(favoriteFoods);
    }
}

public class ImmutablePatterns {
}
