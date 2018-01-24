package company.ocajp1;

/**
 * Created by user on 19.01.2018.
 */

interface I{
    int BAR = 42;
    static String m(){
        return "I.m";
    }

}

class AAA implements I{
    public static void main(String[] args) {
        System.out.println(BAR);
        System.out.println(I.BAR);

        System.out.println(I.m());
        //System.out.println(m());
        ///System.out.println(new AAA.m());
    }
}