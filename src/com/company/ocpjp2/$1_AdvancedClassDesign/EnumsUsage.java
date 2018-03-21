package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 07.03.2018.
 */

//---OK
enum Seasons{
    WINTER, SPRING, SUMMER, AUTUMN
}
//---OK
enum Seasons1{
    WINTER, SPRING, SUMMER, AUTUMN;
}
//---OK
enum Seasons2{
    WINTER, SPRING, SUMMER, AUTUMN;
};
//---OK
enum Seasons3{
    WINTER, SPRING, SUMMER, AUTUMN;;;
};;;;
//---OK
enum Seasons4{
    WINTER, SPRING, SUMMER, AUTUMN; // ; теперь обязательна, иначе ошибка компиляции

    private Seasons4() { // private или по умолчанию, иначе ошибка компиляции
    }
}
//---!
/*enum Seasons5{
    WINTER, SPRING, SUMMER, AUTUMN // ОШИБКА КОМПИЛЯЦИИ

    public Seasons5() { // ОШИБКА КОМПИЛЯЦИИ
    }
}*/
//---OK
enum Seasons6{
    WINTER(), SPRING(1), SUMMER(""), AUTUMN;

    private Seasons6() {
    }

    Seasons6(int i) {

    }

    Seasons6(String s) {

    }
}
//---!
/*enum Seasons7{
    WINTER(),  // ОШИБКА КОМПИЛЯЦИИ
    SPRING(1),
    SUMMER(""),
    AUTUMN; // ОШИБКА КОМПИЛЯЦИИ

    Seasons7(int i) {

    }

    Seasons7(String s) {

    }
}*/
//---!
/*static enum Seasons8{ // ОШИБКА КОМПИЛЯЦИИ
    WINTER, SPRING, SUMMER, AUTUMN
}*/
//---
public class EnumsUsage {
    //---OK
    enum Seasons{
        WINTER, SPRING, SUMMER, AUTUMN
    }
    //---OK
    private static enum Seasons2{
        WINTER, SPRING, SUMMER, AUTUMN
    }

    void m(){
        //---!
       /* enum Seasons{ // ОШИБКА КОМПИЛЯЦИИ
            WINTER, SPRING, SUMMER, AUTUMN
        }*/
    }
}
