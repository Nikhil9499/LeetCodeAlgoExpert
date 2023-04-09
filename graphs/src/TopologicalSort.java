import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
/*
Input:
7
7
0 1
1 2
2 3
0 3
4 5
5 6
4 6

Output:
4
5
6
0
1
2
3
*/

// A permutation of vertices for a directed acyclic graph is called topological sort if for all directed edges uv, u appears before v in the graph
public class TopologicalSort {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
        }

        // write your code here
        topologicalSort(graph);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[]visited = new boolean[graph.length];
        for (int i=0; i< graph.length; i++) {
            if (visited[i] == false) {
                topologicalSortUtil(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int src, boolean[]visited, Stack<Integer> stack) {
        visited[src] = true;
        for (Edge edge: graph[src]) {
            if (visited[edge.nbr] == false) {
                topologicalSortUtil(graph, edge.nbr, visited, stack);
            }
        }
        stack.push(src);
    }

}