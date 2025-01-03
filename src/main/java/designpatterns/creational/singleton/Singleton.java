package designpatterns.creational.singleton;

public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {}

    // synchronized is called just once for the first time using double checked locking technique.
    public static Singleton getInstance() {
        if(uniqueInstance == null) {
            synchronized (Singleton.class) {
                if(uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
