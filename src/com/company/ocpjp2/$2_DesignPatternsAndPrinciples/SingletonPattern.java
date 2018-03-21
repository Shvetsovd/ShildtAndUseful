package company.ocpjp2.$2_DesignPatternsAndPrinciples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.03.2018.
 */
class StringCache {
    private List<String> data;

    private static final StringCache INSTANCE = new StringCache();

    private StringCache() {
        data = new ArrayList<>();
    }

    public StringCache getInstance(){
        return INSTANCE;
    }

    public synchronized int addToCache(String str){
        data.add(str);
        return data.size() - 1;
    }
    public synchronized String getfromCache(int index){
        return data.remove(index);
    }
}

class StringCache1 {
    private List<String> data;
    static {
        //...
        INSTANCE = new StringCache1();
        //...
    }
    private static final StringCache1 INSTANCE;



    private StringCache1() {
        data = new ArrayList<>();
    }

    public StringCache1 getInstance() {
        return INSTANCE;
    }

    public synchronized int addToCache(String str) {
        data.add(str);
        return data.size() - 1;
    }

    public synchronized String getfromCache(int index) {
        return data.remove(index);
    }
}

class StringCache2 {
    private List<String> data;

    private static StringCache2 instance;

    private StringCache2() {
        data = new ArrayList<>();
    }

    public synchronized StringCache2 getInstance(){
        if (instance == null){
            instance = new StringCache2();
        }
        return instance;
    }

    public synchronized int addToCache(String str){
        data.add(str);
        return data.size() - 1;
    }
    public synchronized String getfromCache(int index){
        return data.remove(index);
    }
}
class Singleton {
    public static void main(String[] args) {
        Runtime.getRuntime();
    }
}
