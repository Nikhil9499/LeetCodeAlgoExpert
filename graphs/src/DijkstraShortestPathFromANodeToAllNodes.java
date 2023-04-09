import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;


/*
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30
*/


// For a given source node in the graph, the algorithm finds the shortest path between that node and every other.
// It can also be used for finding the shortest paths from a single node to a single destination node by stopping the algorithm once the shortest path to the destination node has been determined.
public class DijkstraShortestPathFromANodeToAllNodes {
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
        // write your code here
        shortestPathFromANodeToAllOtherNodes(graph, src);
    }

    // It is same as BFS, we just have to use PriorityQueue instead of normal queue
    public static void shortestPathFromANodeToAllOtherNodes(ArrayList<Edge>[] graph, int src) {
        boolean[]visited = new boolean[graph.length];
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1, p2) -> p1.wsf - p2.wsf);
        priorityQueue.offer(new Pair(src, src+"", 0));

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();

            if (visited[pair.vertex]) {
                continue;
            }

            System.out.println(pair.vertex + " via " + pair.psf + " @ " + pair.wsf);
            visited[pair.vertex] = true;

            for (Edge edge: graph[pair.vertex]) {
                if (visited[edge.nbr] == false) {
                    priorityQueue.offer(new Pair(edge.nbr, pair.psf + edge.nbr, pair.wsf + edge.wt));
                }
            }
        }
    }

    static class Pair {
        int vertex;
        String psf;
        int wsf;

        public Pair(int vertex, String psf, int wsf) {
            this.vertex = vertex;
            this.psf = psf;
            this.wsf = wsf;
        }
    }

}
