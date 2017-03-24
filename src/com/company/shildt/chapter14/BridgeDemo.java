package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class GenBridge<T> {
    T ob;

    GenBridge(T o) {
        ob = o;
    }

    public T getOb() {
        return ob;
    }
}

class Gen2Bridge extends GenBridge<String> {
    Gen2Bridge(String o) {
        super(o);
    }

    @Override
    public String getOb() {
        System.out.println("Вызван метод String getOb():");
        return ob;
    }
    //Comp/ will create here a synthetic bridge method like this:
    /*public Object getOb(){
            //call String getOb();
    }*/
}

public class BridgeDemo {
    public static void main(String[] args) {
        Gen2Bridge strOb = new Gen2Bridge("Тест обобщений");
        System.out.println(strOb.getOb());
    }

}
