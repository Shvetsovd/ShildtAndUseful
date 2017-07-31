package company.myUseful.patterns.singleton;

/*
*  Шаблон Singleton ("Одиночка") гарантирует наличие не более экземпляра класса в контексте выполнения
*
*  Варианты реализации:
*
*  1) public static final экземпляр (+ простой, потокобезопасный, -  неленивая инициализация)
*
*  2) enum (+ простой, потокобезопасный, сериализация из коробки, - неленивая инициализация)
*
*  3) synchronized accessor (+ ленивая инициализация, - плата за синхронизацию при каждом обращении к accessor'у)
*
*  4) double checked locking & volatile (+ ленивая инициализация, высокая производительность)
*
*  5) nested-static holder class
*
* */
class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
}

enum Singletone2 {
    INSTANCE;
}

class Singleton3 {
    private static Singleton3 instance;

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

//можно использовать также для ленивой инициализации нестатических полей
class Singleton4 {
    private static volatile Singleton4 instance;

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

//можно использовать также для ленивой инициализации статических полей
class Singleton5 {

    private static class SingletoneHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletoneHolder.INSTANCE;
    }
}

