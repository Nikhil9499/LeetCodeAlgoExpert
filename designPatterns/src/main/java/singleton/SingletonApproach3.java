package singleton;

public class SingletonApproach3 {
    private static SingletonApproach3 instance;

    private SingletonApproach3() {
    }

    public static SingletonApproach3 getInstance() {
        if (instance == null) {
            instance = new SingletonApproach3();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "" + getInstance().hashCode();
    }
}
