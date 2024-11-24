import java.util.Arrays;

public class FloydWarshall {
    final static int INF = 99999;

    public static void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];


        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];


        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

       // printSolution(dist, V);
    }

    public static void printSolution(int dist[][], int V) {
        System.out.println("Matricea cu cele mai scurte distanțe între fiecare pereche de noduri:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }


}
