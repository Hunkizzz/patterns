package creational.singleton;

public final class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        // Этот код эмулирует медленную инициализацию.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }

//    private static final Object lock = new Object();
//    private static volatile YourObject instance;
//
//    public static YourObject getInstance() {
//        YourObject r = instance;
//        if (r == null) {
//            synchronized (lock) {    // While we were waiting for the lock, another
//                r = instance;        // thread may have instantiated the object.
//                if (r == null) {
//                    r = new YourObject();
//                    instance = r;
//                }
//            }
//        }
//        return r;
//    }
}