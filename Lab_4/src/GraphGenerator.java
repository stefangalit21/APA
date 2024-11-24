import java.util.Random;

public class GraphGenerator {
    final static int INF = 99999;

    public static int[][] generateSparseGraph(int V) {
        int[][] graph = new int[V][V];
        Random rand = new Random();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j && rand.nextDouble() < 0.1) {
                    graph[i][j] = rand.nextInt(50) + 1;
                } else {
                    graph[i][j] = INF;
                }
            }
        }

        return graph;
    }

    public static int[][] generateDenseGraph(int V) {
        int[][] graph = new int[V][V];
        Random rand = new Random();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    graph[i][j] = rand.nextInt(50) + 1;
                } else {
                    graph[i][j] = 0;
                }
            }
        }

        return graph;
    }
}
