package recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        printNTo1(10);
    }

    public static void printNTo1(int n) {
        if (n<=0) {
            return;
        }

        System.out.print(n + " ");
        printNTo1(n-1);
    }
}
