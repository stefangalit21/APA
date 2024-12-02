public class Main {
    public static void main(String[] args) {
        int V = 1000;
        System.out.println("Generare grafuri...");

        int[][] sparseGraph = GraphGenerator.generateSparseGraph(V);
        int[][] denseGraph = GraphGenerator.generateDenseGraph(V);

        System.out.println("Analiză pentru graf rar:");
        measureFloydWarshall(sparseGraph, V);
        measureDijkstra(sparseGraph, V);

        System.out.println("\nAnaliză pentru graf dens:");
        measureFloydWarshall(denseGraph, V);
        measureDijkstra(denseGraph, V);
    }


    private static void measureFloydWarshall(int[][] graph, int V) {
        long startTime = System.nanoTime();
        FloydWarshall.floydWarshall(graph, V);
        long endTime = System.nanoTime();
        System.out.println("Floyd-Warshall: " + (endTime - startTime) / 1e6 + " ms");
    }

    private static void measureDijkstra(int[][] graph, int V) {
        long startTime = System.nanoTime();
        for (int src = 0; src < V; src++) {
            Dijkstra.dijkstra(graph, src, V);
        }
        long endTime = System.nanoTime();
        System.out.println("Dijkstra: " + (endTime - startTime) / 1e6 + " ms");
    }
}
