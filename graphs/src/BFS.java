import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*

Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2

Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

*/

public class BFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        int vertex;
        String psf;

        public Pair(int vertex, String psf) {
            this.vertex = vertex;
            this.psf = psf;
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
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        bfs(graph, src);
    }

    public static void bfs(ArrayList<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(src, src+""));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (visited[pair.vertex]) {
                continue;
            }
            System.out.println(pair.vertex+"@"+pair.psf);
            visited[pair.vertex] = true;

            for (Edge edge: graph[pair.vertex]) {
                if (!visited[edge.nbr]) {
                    queue.offer(new Pair(edge.nbr, pair.psf + edge.nbr));
                }
            }
        }
    }
}