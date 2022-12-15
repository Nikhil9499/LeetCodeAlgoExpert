package singleton;

public class SingletonApproach4 {
    /* Volatile keyword:
    1. The Java volatile keyword cannot be used with method or class and it can only be used with a variable.
    2. Java volatile keyword also guarantees visibility and ordering, after Java 5 writes to any volatile
        variable happens before any read into the volatile variable.
    3. Volatile keyword in Java is used as an indicator to Java compiler and Thread that do not cache the
        value of this variable and always read it from the main memory.
    4. Read and write operation is Atomic by implementation
    */
    private static volatile SingletonApproach4 instance;

    private SingletonApproach4() {}

    public static SingletonApproach4 getInstance() {
        if (instance == null) {
            synchronized (SingletonApproach4.class) {
                if (instance == null) {
                    instance = new SingletonApproach4();
                }
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return "" + getInstance().hashCode();
    }
}
