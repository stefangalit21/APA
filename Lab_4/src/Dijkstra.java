import java.util.Arrays;

public class Dijkstra {
    public static void dijkstra(int graph[][], int src, int V) {
        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = selectMinVertex(dist, visited, V);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

       // printSolution(dist, V);
    }

    public static int selectMinVertex(int dist[], boolean visited[], int V) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void printSolution(int dist[], int V) {
        System.out.println("Distanța de la sursă la fiecare nod:");
        for (int i = 0; i < V; i++) {
            System.out.println("Nod " + i + " -> " + dist[i]);
        }
    }


}
