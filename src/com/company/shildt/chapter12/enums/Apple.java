package company.shildt.chapter12.enums;

/**
 * Created by dmitry on 24.02.17.
 */
public enum Apple {
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price;

    Apple() {
        this.price = -1;
    }

    Apple(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
