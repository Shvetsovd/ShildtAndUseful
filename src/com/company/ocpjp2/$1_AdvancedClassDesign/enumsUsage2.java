package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 07.03.2018.
 */
enum SeasonsOfYear{
    WINTER("Cold"), SPRING("Warm"), SUMMER("Hot"), FALL("Rainy");

    private String weather;
    SeasonsOfYear(String weather) {
        this.weather = weather;
    }

    public String getWeather(){
        return weather;
    }
}

enum Season1 {
    WINTER {
        public void printHours() { System.out.println("short hours"); }
    }, SUMMER {
        public void printHours() { System.out.println("long hours"); }
    }, SPRING {
        @Override
        public void printHours() { System.out.println("default hours"); }
    }, FALL {
        @Override
        public void printHours() { System.out.println("default hours"); }

        public void m(){} // не будет видно по ссылке Season1
        String[] months = {"September", "October", "November"}; // не будет видно по ссылке Season1
    };
    public abstract void printHours();
}

enum Season2 {
    WINTER {
        public void printHours() { System.out.println("short hours"); }
    }, SUMMER {
        public void printHours() { System.out.println("long hours"); }
    }, SPRING, FALL;
    public void printHours() { System.out.println("default hours"); }
}
public class enumsUsage2 {
    public static void main(String[] args) {

    }
}
