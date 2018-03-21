package company.my.automate.module.box;

/**
 * Created by user on 02.03.2018.
 */
public  abstract class BoxBase<T> implements Box<T>{
    private int id;
    private T container;
    private boolean isEmpty;

    public BoxBase(int id) {
        this.id = id;
        this.isEmpty = true;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void put(T object) {
        container = object;
        isEmpty = false;
    }

    @Override
    public T open() {
        T object = container;
        container = null;
        isEmpty = true;
        return object;
    }

    @Override
    public String toString() {
        return "BoxBase{" +
                "id=" + id +
                ", container=" + container +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
