import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Input: output: false
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10

true
7
6
0 1 10
1 2 10
2 3 10
4 5 10
5 6 10
4 6 10

*/

public class IsGraphCyclic {
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
        System.out.println(isCyclic(graph, vtces));
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int vertices) {
        boolean[]visited = new boolean[graph.length];

        for (int i=0; i<vertices; i++) {
            if (visited[i] == false) {
                Queue<Pair> queue = new LinkedList<>();
                queue.offer(new Pair(i, i + ""));

                while(!queue.isEmpty()) {
                    Pair pair = queue.poll();

                    if (visited[pair.vertex]) {
                        return true;
                    }

                    visited[pair.vertex] = true;
                    for (Edge edge: graph[pair.vertex]) {
                        if (visited[edge.nbr] == false) {
                            queue.offer(new Pair(edge.nbr, pair.psf + edge.nbr));
                        }
                    }
                }
            }
        }

        return false;
    }

    static class Pair {
        int vertex;
        String psf;

        public Pair(int vertex, String psf) {
            this.vertex = vertex;
            this.psf = psf;
        }
    }

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
}