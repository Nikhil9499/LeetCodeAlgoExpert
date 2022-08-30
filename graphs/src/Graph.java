import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {
        int v = 5;
        adjMatrix(v);
        adjList(v);
    }

    public static int[][] adjMatrix(int v) {
        int[][]graph = new int[v][v];
        for(int i=0; i<v; i++) {
            for(int j=0; j<v; j++) {
                graph[i][j] = i+j;
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        return graph;
    }

    public static void adjList(int v) {
        ArrayList<ArrayList<Integer>> adj
                = new ArrayList<>(v);

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());

        // Adding edges one by one
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer> > adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                    + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                        + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

}
