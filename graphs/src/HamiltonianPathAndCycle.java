import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Input:
-------
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Output:
-------
0123456 -> path
0123465 -> path
0125643 -> cycle
0346521 -> cycle

*/

public class HamiltonianPathAndCycle {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
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
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        int src = Integer.parseInt(br.readLine());

        // write all your codes here
        Set<Integer> visited = new HashSet<>();
        printHamiltonianPathAndCycle(graph, visited, src, src, src + "");
    }

    public static void printHamiltonianPathAndCycle(ArrayList<Edge>[] graph, Set<Integer> visited, int src, int osrc, String pathSoFar) {

        if (visited.size() == graph.length - 1) { // visited = no of vertices
            System.out.print(pathSoFar +" -> ");

            // for cycle, check if current src has any edge with original src
            for (Edge edge: graph[src]) {
                if (edge.nbr == osrc) {
                    System.out.println("cycle");
                    return;
                }
            }

            System.out.println("path");
            return;
        }

        visited.add(src);
        for(Edge edge: graph[src]) {
            if (visited.contains(edge.nbr) == false) {
                printHamiltonianPathAndCycle(graph, visited, edge.nbr, osrc, pathSoFar + edge.nbr);
            }
        }
        visited.remove(src);
    }


}