package company.my.automate.module.box;

/**
 * Created by user on 02.03.2018.
 */
public interface Box<T> {
    boolean isEmpty();
    int getId();
    void put(T object);
    T open();
}
