package company.myUseful;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static java.lang.Math.abs;
import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

/**
 * Created by dmitry on 21.01.17.
 */
public class Useful {
    public static void main(String[] args) throws IOException {

        bOperation();
        //  Строка в число
        /*String sNum = "1234";
        int num = stringToNum(sNum);

        System.out.println("String = \"" + sNum + "\"\nint = " + num);*/

        //numToBinary(0xC, 8);

        //число в строку
        //int x = 1234;
        //System.out.println(numToString(x));

        //double y = -123.456;
        //System.out.println(numToString(y));
        //Чтение всех битов в числе
        //int x = 12;
        //System.out.println(bitsInNumber(x, Integer.BYTES * 8));

        //подсчет количества 0 и 1 в числе
        //int x = 8;
        //zeroOneCounts(x, Integer.SIZE);

        //Вывод числа в hex-коде
        //int x = 1000000;
        //System.out.println(hexView(x, Integer.SIZE));

        //int[] arr1 = {5, 8, 4, 9, 12, 0, 20, 3, 1};



        //  Бинарный поиск
        //binarySearch(arr1, 9);

        //Быстрая сортировка
        //int[] arr2 = { 5, 3, 5, 7, 8, 0 };
        //quickSort(arr2, 0, arr2.length - 1);
        //System.out.println(Arrays.toString(arr2));

        //Чтение директории
/*        File dir = new File("/home/dmitry/");
        dir.getCanonicalPath();

        if(dir.isDirectory()){
            String[] fileInDir = getDirContent(dir);

            for (String f : fileInDir) System.out.println(f);
        }*/


    }

    private static void bOperation(){
        int a = ~0;
        a <<= 1;
        System.out.println(a);
    }

    private static int stringToNum(String sNum){

        int num = 0;

        for (int i = 0; i < sNum.length(); i ++){
            num *= 10;
            num += Integer.parseInt(sNum.substring(i, i + 1));
        }

        return num;
    }

    private static String numToBinary(int num, int minDigitsCount){

        String bNum;
        StringBuilder sb = new StringBuilder();

        do{

            sb.append(num % 2);
            num /= 2;

        }while(num != 0);


        if(sb.length() < minDigitsCount){
            int appendCount = minDigitsCount - sb.length();
            for(int i = 0; i < appendCount; i++){
                sb.append("0");
            }
        }

        bNum = sb.reverse().toString();
        System.out.println(bNum);

        return bNum;

    }

    private static int[] arraysSort(int arr[]){

        //int[] arr1 = copyOf(arr, arr.length);

        sort(arr);
        System.out.println(Arrays.toString(arr));

        //System.out.println(Arrays.toString(arr1));

        return arr;
    }

    private static void simpleNumbers(int maxNumber) {
        boolean isSimple = true;

        for(int i = 1; i <= maxNumber; i++){
            isSimple = true;
            for(int j = 2; j <= i/2; j++){
                if(i % j == 0){
                    isSimple = false;
                    break;
                }
            }
            if (isSimple){
                System.out.println(i);
            }
        }
    }


    private static int[] bubleSort(int[] arr){

        System.out.println("Buble sort for array:");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Buble sort finished\n");
        return arr;
    }



    private static void binarySearch(int arr[], int value){


        System.out.println("Binary search for array:");
        System.out.println(Arrays.toString(arr) + "\n");

        arr = bubleSort(arr);

        boolean isFound = false;

        int first = 0;
        int last = arr.length - 1;
        int pos = 0;

        while (first <= last){
            pos = (first + last) / 2;

            if(arr[pos] == value){
                isFound = true;
                break;
            }else if(arr[pos] > value){
                last = pos - 1;
                continue;
            }else if(arr[pos] < value){
                first = pos + 1;
                continue;
            }
        }

        if(isFound){
            System.out.println("Number " + arr[pos] + " found at position " + ++pos);
        }else {
            System.out.println("Number not found");
        }
        System.out.println("Binary search finished\n");
    }

    public static String[] getDir(File dir){
            return dir.list();
    }

    public static void quickSort(int[] arr, int start, int end){

        int l = start;
        int r = end;

 /*       int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++){
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int mediana = (max - min) / 2;*/
        int pivot = arr[start + (end - start) / 2];

        while (l <= r) {

            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if(l <= r) {
                swap(arr, l++, r--);
            }
        }

        if (start < r) { quickSort(arr, start, r); }
        if (end > l) { quickSort(arr, l, end); }

    }
    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static String bitsInNumber(int num, int numBits){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numBits; i++){
            str.append((num >>> i) & 1);
        }
        str.reverse();
        return str.toString();
    }

    private static void zeroOneCounts(int num, int size){
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < size; i++){
            if( ((num >>> i) & 0x1) == 0 ){
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }
        System.out.println("zeroCount: " + zeroCount);
        System.out.println("oneCount: " + oneCount);
    }

    private static String hexView(int num, int size){
        boolean isNegative = false;
        String[] hex = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
                        "9", "Outer", "B", "C", "D", "E", "F"};
        StringBuilder sb = new StringBuilder();

        if (num < 0) {
            isNegative = true;
            num = ~num;
            num++;
        }
        for (int i = 0; i <= (size - 1) / 4; i++){
            int octa = (num >>> (4 * i)) & 0xF;
            sb.append(hex[octa]);
        }

        if (isNegative){ sb.append("-"); }

        return sb.reverse().toString();



    }

    private static String numToString(int num){
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            sb.append(num % 10);
            num /= 10;
        }
        return sb.reverse().toString();
    }

    private static String numToString(double num){
        StringBuilder sb = new StringBuilder();

        int m = (int) abs(num);
        double f = abs(num) - m;

        while (m != 0){
            sb.append( m % 10 );
            m /= 10;
        }


        if (num < 0.0){ sb.append("-"); }

        sb.reverse();
        sb.append('.');

        while (f > 0.001){
            f *= 10.0;
            sb.append((int)f );
            f -= (int)f;
        }

        return sb.toString();
    }
}


