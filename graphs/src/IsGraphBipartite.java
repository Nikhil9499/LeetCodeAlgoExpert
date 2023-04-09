import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*

Input:
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

false

4
4
0 1 10
1 2 10
2 3 10
0 3 10


*/

// All acyclic graphs are bipartite. A cyclic graph is bipartite iff all its cycles are of even length
// A graph is bipartite if and only if each of the connected components is bipartite.
public class IsGraphBipartite {
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
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[]visited = new int[graph.length];
        for (int i=0; i< graph.length; i++) {
            if (visited[i] == 0) {
                Queue<Pair> queue = new LinkedList<>();
                queue.offer(new Pair(i, i+"", 0));

                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();

                    if (visited[pair.vertex] != 0) {
                        // cyclic => check for even and odd cycle => using levels
                        // for even cycle, levels will be same & for odd cycles, levels will be different
                        if (pair.level != visited[pair.vertex]) {
                            return false;
                        }
                    } else {
                        visited[pair.vertex] = pair.level;
                    }

                    for (Edge edge: graph[pair.vertex]) {
                        if (visited[edge.nbr] == 0) {
                            queue.offer(new Pair(edge.nbr, pair.psf + edge.nbr, pair.level+1));
                        }
                    }
                }
            }
        }

        return true;
    }

    static class Pair{
        int vertex;
        String psf;
        int level;

        public Pair(int vertex, String psf, int level) {
            this.vertex = vertex;
            this.psf = psf;
            this.level = level;
        }
    }
}
