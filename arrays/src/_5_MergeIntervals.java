import java.util.*;

public class _5_MergeIntervals {
    public static void main(String[] args) {
        int[][] mat = {{1,3},{2,4},{6,8},{9,10}};
        // Output: {{1, 4}, {6, 8}, {9, 10}}
        System.out.println(mergeIntervals(mat));
        mergeIntervalsUsingStack(mat);

        mat = new int[][]{{6,8},{1,9},{2,4},{4,7}};
        // Output: {{1, 9}}
        System.out.println(mergeIntervals(mat));
        mergeIntervalsUsingStack(mat);
    }

    public static List<List<Integer>> mergeIntervals(int[][]mat) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Pair> pairs = new ArrayList<>();
        for (int i=0; i< mat.length; i++) {
            pairs.add(new Pair(mat[i][0], mat[i][1]));
        }

        pairs.sort(Comparator.comparing(pair -> pair.start));
//        System.out.println(pairs);
        int n = pairs.size();

        // {{1,3},{2,4},{6,8},{9,10}}
        int index = 0;
        for (int i=1; i < n; i++) {
            Pair ith = pairs.get(index);
            Pair i1th = pairs.get(i);
            if (ith.end >= i1th.start) {
                ith.end = Math.max(ith.end, i1th.end);
                pairs.set(index, ith);
            } else {
                index++;
                pairs.set(index, i1th);
            }
//            System.out.println(pairs);
        }

        for (int i=0; i<=index; i++) {
            List<Integer> intervals = new ArrayList<>();
            intervals.add(pairs.get(i).start);
            intervals.add(pairs.get(i).end);
            ans.add(intervals);
        }

        return ans;
    }

    public static void mergeIntervalsUsingStack(int[][]arr) {
        // Test if the given set has at least one interval
        if (arr.length <= 0)
            return;

        // Create an empty stack of intervals
        Stack<Pair> stack=new Stack<>();
        Pair[] intervals = new Pair[arr.length];
        for (int i=0; i<arr.length; i++) {
            intervals[i] = new Pair(arr[i][0], arr[i][1]);
        }

        // sort the intervals in increasing order of start time
        Arrays.sort(intervals, Comparator.comparing(pair -> pair.start));

        // push the first interval to stack
        stack.push(intervals[0]);

        // Start from the next interval and merge if necessary
        for (int i = 1 ; i < arr.length; i++) {
           if (stack.peek().end >= intervals[i].start) {
               stack.peek().end = Math.max(stack.peek().end, intervals[i].end);
           } else {
               stack.push(intervals[i]);
           }
        }

        // Print contents of stack
        System.out.print("[");
        while (!stack.isEmpty()) {
            System.out.print("[" + stack.pop() + "] ");
        }
        System.out.println("]");
    }

    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return  start + " " + end;
        }
    }
}
