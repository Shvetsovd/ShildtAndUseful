package company.myUseful.abstractTest;

public class Main {

    public static void main(String[] args) {
        int[][][] num1 = {
                {
                        {1, 2},
                        {3, 4}
                },
                {
                        {5, 6},
                        {7, 8}
                }
        };
	// write your code here

        /*int[][][] arr2 = {
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                },
                {
                        {10, 11, 12},
                        {13, 14, 15},
                        {16, 17, 18}
                },
                {
                        {19, 20, 21},
                        {22, 23, 24},
                        {25, 26, 27}
                }
        };



        for(int i = 0; i < arr3.length; i++){
            for(int j = 0; j < arr3[i].length; j++){
                for (int k = 0; k < arr3[i][j].length; k++){
                    System.out.print(arr3[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int x[][] : arr3){
            for (int y[] : x){
                for (int k : y){
                    System.out.print(k + " ");
                }
                System.out.println();
            }
            System.out.println();
        }*/



        AbstractClassTest a = new RealClass();
        RealClass b = new RealClass();
        a.f();
        //a.x - error
        b.f();
        b.x = 5;

    }
}
