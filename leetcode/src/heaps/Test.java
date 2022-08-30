package heaps;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(9));
        double b = Math.sqrt(9);
        if (b == (int)b){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        int n = 8;
        System.out.println((-2/2));
        System.out.println((n&(n-1)) == 0);
        Math.pow(2, 3);
    }

    public static int[] sortByBits(int[] arr) {
        if (arr.length < 2) return arr;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                (a,b) -> Integer.bitCount(a) != Integer.bitCount(b) ? Integer.bitCount(a) - Integer.bitCount(b) : a-b
        );

        for (int i=0; i<arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int i=0;
        while(minHeap.size() > 0) {
            arr[i] = minHeap.remove();
            i++;
        }

        return arr;
    }
}
