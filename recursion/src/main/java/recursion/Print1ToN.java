package recursion;

public class Print1ToN {
    public static void main(String[] args) {
        print1ToN(10);
    }

    public static void print1ToN(int n) {
        if (n<=0) {
            return;
        }

        print1ToN(n-1);
        System.out.print(n + " ");
    }
}
