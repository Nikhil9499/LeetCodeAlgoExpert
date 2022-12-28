package singleton;

public class SingletonApproach1 {
    private static final SingletonApproach1 instance = new SingletonApproach1();

    private SingletonApproach1() {
    }

    public static SingletonApproach1 getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "" + getInstance().hashCode();
    }
}
