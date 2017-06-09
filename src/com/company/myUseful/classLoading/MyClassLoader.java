package company.myUseful.classLoading;

/**
 * Created by OPER on 09.06.2017.
 */
public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //или создаем байтовый массив, грузим в него из источника байты класса и вызываем defineClass();
        return super.loadClass(name);
    }
}
