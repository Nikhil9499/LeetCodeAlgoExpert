import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/*
Input:
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8

Output:
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]
*/


public class PrimAlgo_MinimumWIreToConnectAllPcs {
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

        // write your code here
        minimumWireToConnectAllPcs_PrimAlgo(graph);
    }

    public static void minimumWireToConnectAllPcs_PrimAlgo(ArrayList<Edge>[] graph) {
        boolean[]visited = new boolean[graph.length];
        int src = 0;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1, p2) -> p1.wsf - p2.wsf);
        priorityQueue.offer(new Pair(src, "-1", 0));

        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();

            if (visited[pair.vertex]) {
                continue;
            }
            if (!pair.psf.equals("-1")) {
                System.out.println("[" + pair.vertex + "-" + pair.psf + "@" + pair.wsf + "]");
            }
            visited[pair.vertex] = true;

            for (Edge edge: graph[pair.vertex]) {
                if (visited[edge.nbr] == false) {
                    priorityQueue.offer(new Pair(edge.nbr, pair.vertex +"", edge.wt));
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
