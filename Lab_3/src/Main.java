import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int V = 100;

        System.out.println("Comparing Kruskal's and Prim's Algorithms in Different Scenarios");


        Graph favorableGraph = generateGraph(V, V - 1);
        System.out.println("\nFavorable Case: V-1 edges");
        runComparison(favorableGraph);


        Graph unfavorableGraph = generateGraph(V, V * (V - 1) / 2);
        System.out.println("\nUnfavorable Case: V(V-1)/2 edges");
        runComparison(unfavorableGraph);


        Graph averageGraph = generateGraph(V, V * (V - 1) / 4 + 1);
        System.out.println("\nAverage Case: V(V-1)/4 + 1 edges");
        runComparison(averageGraph);
    }

    public static Graph generateGraph(int V, int E) {
        Graph graph = new Graph(V);
        Random rand = new Random();
        int edgeCount = 0;

        while (edgeCount < E) {
            int src = rand.nextInt(V);
            int dest = rand.nextInt(V);
            int weight = rand.nextInt(100) + 1;

            if (src != dest && !graph.edges.contains(new Edge(src, dest, weight))) {
                graph.addEdge(src, dest, weight);
                edgeCount++;
            }
        }

        return graph;
    }

    public static void runComparison(Graph graph) {

        KruskalAlgorithm kruskal = new KruskalAlgorithm(graph);
        long startTime = System.nanoTime();
        kruskal.kruskalMST();
        long kruskalTime = System.nanoTime() - startTime;
        System.out.println("Kruskal's Algorithm Execution Time: " + kruskalTime + " ns");


        PrimAlgorithm prim = new PrimAlgorithm(graph);
        startTime = System.nanoTime();
        prim.primMST();
        long primTime = System.nanoTime() - startTime;
        System.out.println("Prim's Algorithm Execution Time: " + primTime + " ns");
    }
}
