package company.my.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 18.04.2018.
 */
public class WekReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        List<Reference<BigArray>> list = new ArrayList<>();
        //List<BigArray> listHolder = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            BigArray a = new BigArray();

            //listHolder.add(a);
            list.add(new WeakReference<BigArray>(a));

            System.out.println(Runtime.getRuntime().freeMemory() / 1024 / 1024 + " MB");
            Thread.sleep(50);
        }

    }
}
class BigArray{
    private static long idGenerator = 0;
    private final long id = idGenerator++;
    private long[] a;

    public BigArray() {
        this.a = new long[1_000_000];
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize: " + id);
    }
}
