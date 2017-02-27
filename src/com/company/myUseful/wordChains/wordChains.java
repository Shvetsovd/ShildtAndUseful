package company.myUseful.wordChains;

import java.util.ArrayList;

/**
 * Created by OPER on 27.02.2017.
 */

public class wordChains {
    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<String>();
        String data = "Киев Нью-Йорк Амстердам Вена Мельбурн";
        //String data = "Zitomir Moskva Achinsk Voronez Krasnoyarsk Kostroma Vilnus Sorsk Kishinev Abakan Kiev Norilsk Rovno Orel Lipesk Anapa";
        //String data = "ab ca ad bd db bc ba";
        words = loadDataToList(data);

        ArrayList<String> chain = new ArrayList<String>();

        long start = System.currentTimeMillis();

        while (true) {
            if (isValidChain(chain, words)) break;
            chain = getChain((ArrayList<String>) words.clone());
        }

        long finish = System.currentTimeMillis();

        System.out.println(chain);
        System.out.println("Searching time = " + (finish - start));
    }

    private static ArrayList<String> loadDataToList(String data) {
        ArrayList<String> dataInList = new ArrayList<String>();
        data.trim();
        String arr[] = data.split(" ");
        for (String s : arr) {
            dataInList.add(s);
        }
        return dataInList;
    }

    public static ArrayList<String> getChain(ArrayList<String> words) {

        ArrayList<String>
                chain = new ArrayList<String>();

        ArrayList<String>
                nextWords = getNextWords(null, words);

        while (nextWords.size() != 0) {
            int i = (int) (Math.random() * (nextWords.size() - 1));
            String word = nextWords.get(i);

            chain.add(word);
            deleteFromList(word, words);
            nextWords = getNextWords(word, words);
        }

        return chain;
    }

    private static void deleteFromList(String word, ArrayList<String> words) {
        for (int i = 0; i < words.size(); i++) {
            if (word.equals(words.get(i))) {
                words.remove(i);
                break;
            }
        }
    }

    public static ArrayList<String> getNextWords(String word, ArrayList<String> words) {

        ArrayList<String> nextWords = new ArrayList<String>();

        if (word == null) {
            int i = (int) (Math.random() * (words.size() - 1));
            nextWords.add(words.get(i));
            return nextWords;
        }

        for (String w : words) {

            if (word.toLowerCase().charAt(word.length() - 1) == w.toLowerCase().charAt(0)) {
                nextWords.add(w);
            }
        }
        return nextWords;
    }

    public static boolean isValidChain(ArrayList<String> chain, ArrayList<String> words) {
        return chain.size() == words.size();
    }
}
