public class NumberOfIslands {
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 }
        };

        // Number of islands is: 6
        int count = 0;
        boolean[][] visited = new boolean[graph.length][graph[0].length];
        for(int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].length; j++) {
                if (graph[i][j] == 1 && visited[i][j] == false) {
                    count += countIslands(graph, i, j, visited);
                }
            }
        }

        System.out.println(count);

        count = 0;
        for(int i=0; i<graph.length; i++) {
            for (int j=0; j<graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    count++;
                    countIslands2(graph, i, j);
                }
            }
        }

        System.out.println(count);
    }

    public static int countIslands(int graph[][], int i, int j, boolean[][]visited) {
        if (i>=graph.length || i<0 || j<0 || j>=graph[0].length || visited[i][j] || graph[i][j] == 0) {
            return 0;
        }

        visited[i][j] = true;
        countIslands(graph, i+1, j, visited);
        countIslands(graph, i-1, j, visited);
        countIslands(graph, i, j+1, visited);
        countIslands(graph, i, j-1, visited);
        return 1;
    }

    public static void countIslands2(int graph[][], int i, int j) {
        if (i>=graph.length || i<0 || j<0 || j>=graph[0].length || graph[i][j] == 0) {
            return;
        }
        graph[i][j] = 0;
        countIslands2(graph, i+1, j);
        countIslands2(graph, i-1, j);
        countIslands2(graph, i, j+1);
        countIslands2(graph, i, j-1);
    }
}
