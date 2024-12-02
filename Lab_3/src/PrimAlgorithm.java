import java.util.Arrays;

public class PrimAlgorithm {
    private Graph graph;
    private int iterationCount;

    public PrimAlgorithm(Graph graph) {
        this.graph = graph;
        this.iterationCount = 0;
    }

    public void primMST() {
        boolean[] mstSet = new boolean[graph.V];
        int[] key = new int[graph.V];
        int[] parent = new int[graph.V];
        int totalWeight = 0;

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < graph.V - 1; count++) {
            iterationCount++;
            int u = minKey(key, mstSet);


            if (u == -1) {
                System.out.println("Prim's Algorithm could not find a valid node. Skipping further processing.");
                break;
            }

            mstSet[u] = true;

            for (Edge edge : graph.edges) {
                if (edge.src == u || edge.dest == u) {
                    int v = (edge.src == u) ? edge.dest : edge.src;
                    if (!mstSet[v] && edge.weight < key[v]) {
                        parent[v] = u;
                        key[v] = edge.weight;
                    }
                }
            }
        }

        for (int i = 1; i < graph.V; i++) {
            if (key[i] != Integer.MAX_VALUE) {
                totalWeight += key[i];
            }
        }
        System.out.println("Prim's MST Total Cost: " + totalWeight);
        System.out.println("Prim's Algorithm Iterations: " + iterationCount);
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < graph.V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
