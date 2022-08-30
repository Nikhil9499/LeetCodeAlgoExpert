import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class GraphUsingMapAndSet {

    static int v;
    HashMap<Integer, TreeSet<Integer>> graph;

    // Graph Constructor
    public GraphUsingMapAndSet() {
        graph = new HashMap<>();
        for (int i = 0; i < v; i++) {
            graph.put(i, new TreeSet<>());
        }
    }

    public static void main(String[] args) {

        v = 5;
        GraphUsingMapAndSet graph = new GraphUsingMapAndSet();

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

        // Search the given edge in the graph
        graph.searchEdge(2, 1);
        graph.searchEdge(0, 3);
    }

    // Adds an edge to an undirected graph
    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    // A utility function to print the graph
    public void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.println("Adjacency list of vertex " + i);

            for (Integer integer : graph.get(i)) System.out.print(integer + " ");

            System.out.println();
            System.out.println();
        }
    }

    // Searches for a given edge in the graph
    public void searchEdge(int src, int dest) {
        Iterator set = graph.get(src).iterator();

        if (graph.get(src).contains(dest))
            System.out.println("Edge from " + src + " to " +
                    dest + " found");
        else
            System.out.println("Edge from " + src + " to " +
                    dest + " not found");

        System.out.println();
    }
}

