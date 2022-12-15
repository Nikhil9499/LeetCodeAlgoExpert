package singleton;

public class Driver {
    public static void main(String[] args) {
        // Approach 1: Using static final initialization during class loading
        SingletonApproach1 obj1 = SingletonApproach1.getInstance();
        SingletonApproach1 obj2 = SingletonApproach1.getInstance();

        if (obj1 == obj2) {
            System.out.println(obj1+" "+obj2);
            System.out.println("SingletonApproach1: Objects are same");
        } else {
            System.out.println("SingletonApproach1: Objects are not same");
        }
        System.out.println();

        // Approach 2: Enum based: By default creation of Enum instance is thread safe but any other method on Enum is programmers responsibility.
        SingletonApproach2 o1 = SingletonApproach2.INSTANCE;
        SingletonApproach2 o2 = SingletonApproach2.INSTANCE;

        if (o1 == o2) {
            System.out.println(o1+" "+o2);
            System.out.println("SingletonApproach2: Objects are same");
        } else {
            System.out.println("SingletonApproach2: Objects are not same");
        }
        System.out.println();


        // Approach 3: Single locking: Not thread-safe
        SingletonApproach3 object1 = SingletonApproach3.getInstance();
        SingletonApproach3 object2 = SingletonApproach3.getInstance();

        if (object1 == object2) {
            System.out.println(object1+" "+object2);
            System.out.println("SingletonApproach3: Objects are same");
        } else {
            System.out.println("SingletonApproach3: Objects are not same");
        }
        System.out.println();

        // Approach 4: Double locking with lazy initialization: thread-safe
        SingletonApproach4 ob1 = SingletonApproach4.getInstance();
        SingletonApproach4 ob2 = SingletonApproach4.getInstance();

        if (ob1 == ob2) {
            System.out.println(ob1+" "+ob2);
            System.out.println("SingletonApproach4: Objects are same");
        } else {
            System.out.println("SingletonApproach4: Objects are not same");
        }
        System.out.println();

    }
}
