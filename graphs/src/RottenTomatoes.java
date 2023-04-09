import java.util.LinkedList;
import java.util.Queue;


public class RottenTomatoes {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0},
                {1, 2, 0},
                {0, 1, 2}
        };
        int ans = new RottenTomatoes().minMinutes(grid, 3, 3);
        System.out.print(ans);
    }

    public boolean isSameBatch(Pair p) {
        return p.i != -1 && p.j != -1;
    }

    public boolean isSafe(int i, int j, int r, int c) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }

    public void checkValidityAndPopulatedQueue(int[][] grid, int i, int j, int m, int n, Queue<Pair> queue) {
        if (isSafe(i, j, m, n) && grid[i][j] == 1) {
            grid[i][j] = 2;
            queue.offer(new Pair(i, j));
        }
    }

    public boolean checkGridStatus(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public int minMinutes(int[][] grid, int m, int n) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        Queue<Pair> queue = new LinkedList<>();
        // push all indices of 2 into queue to start with
        populateQueueWithInitialValues(grid, queue);

        int minMinutes = 0;
        while (!queue.isEmpty()) {
            while (isSameBatch(queue.peek())) {
                Pair p = queue.poll();
                System.out.println("Pair polled is " + p);
                // left
                checkValidityAndPopulatedQueue(grid, p.i - 1, p.j, m, n, queue);
                //right
                checkValidityAndPopulatedQueue(grid, p.i + 1, p.j, m, n, queue);
                //top
                checkValidityAndPopulatedQueue(grid, p.i, p.j - 1, m, n, queue);
                //bottom
                checkValidityAndPopulatedQueue(grid, p.i, p.j + 1, m, n, queue);
            }
            queue.poll();
            if (!queue.isEmpty()) {
                queue.offer(new Pair(-1, -1));
                minMinutes++;
            }
        }

        if (checkGridStatus(grid)) {
            return -1;
        } else {
            return minMinutes;
        }

    }

    private void populateQueueWithInitialValues(int[][] grid, Queue<Pair> queue) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        // to segregate every min batches(2's)
        queue.offer(new Pair(-1, -1));
    }

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }
}

