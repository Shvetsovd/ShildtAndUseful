package company.ocpjp2.$2_DesignPatternsAndPrinciples;

/**
 * Created by user on 10.03.2018.
 */
public class JavaBean {
    private int age;
    private boolean bird;

    public int getAge() {
        return age;
    }

    public boolean getBird() {
        return bird;
    }
    //Допустимо
    public boolean isBird() {
        return bird;
    }
    /*//Недопустимо
    public Boolean isBird() {
        return bird;
    }*/
    public void setAge(int age) {
        this.age = age;
    }

    public void setBird(boolean bird) {
        this.bird = bird;
    }

}

class Customer {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String aEmail) {
        email = aEmail;
    }
}
