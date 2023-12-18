/**
 * Thuật toán Ford-Fulkerson với thuật toán duyệt DFS để tìm một phần đồ thị (path). Ford-Fulkerson cho phép tìm luồng
 * cực đại (max flow) trên một đồ thị có hướng có trọng số, cũng như tìm lát cắt cực tiểu
 *
 * <p>Time Complexity: O(V^2)
 */

package object;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class FordFulkersonDfsSolverAdjacencyList extends NetworkFlowSolverBase {

    /**
     * Creates an instance of a flow network solver. Use the {@link #addEdge(int, int, int)} method to
     * add edges to the graph.
     *
     * @param n - The number of nodes in the graph including source and sink nodes.
     * @param s - The index of the source node, 0 <= s < n
     * @param t - The index of the sink node, 0 <= t < n, t != s
     */
    public FordFulkersonDfsSolverAdjacencyList(int n, int s, int t) {
        super(n, s, t);
    }

    public static void main(String[] args) {
        System.out.println("Small Flow");
        testSmallFlowGraph();
        System.out.println("----------------------------");
    }

    // Testing graph from:
    // http://crypto.cs.mcgill.ca/~crepeau/COMP251/KeyNoteSlides/07demo-maxflowCS-C.pdf
    private static void testSmallFlowGraph() {
        int n = 6;
        int s = 0;
        int t = 5;

        FordFulkersonDfsSolverAdjacencyList solver = getFordFulkersonDfsSolverAdjacencyList(n, s, t);

        System.out.println("Max flow:" + solver.getMaxFlow()); // 19

        List<Edge>[] g = solver.getGraph();
        System.out.println(solver.getTotalEdge());

        List<Edge> edgesToRemove = new ArrayList<>();

        for (List<Edge> edges : g) {
            for (Edge e : edges) {
                if (e.flow == 0 && !e.isResidual()) {
                    System.out.println(e.toString(s, t));
                    System.out.println();
                    edgesToRemove.add(e);
                }
            }
        }

        System.out.println(solver.getTotalEdge());
    }

    /* Example */

    private static FordFulkersonDfsSolverAdjacencyList getFordFulkersonDfsSolverAdjacencyList(int n, int s, int t) {
        FordFulkersonDfsSolverAdjacencyList solver;
        solver = new FordFulkersonDfsSolverAdjacencyList(n, s, t);

        // Source edge
        solver.addEdge(s, 1, 0, 10);


        solver.addEdge(s, 2, 0, 10);


        // Sink edges
        solver.addEdge(3, t, 0, 10);


        solver.addEdge(4, t, 0, 10);


        // Middle edges
        solver.addEdge(1, 2, 0, 2);


        solver.addEdge(1, 3, 0, 4);


        solver.addEdge(1, 4, 0, 8);


        solver.addEdge(2, 4, 0, 9);


        solver.addEdge(4, 3, 0, 6);

        return solver;
    }

    // Performs the Ford-Fulkerson method applying a depth first search as
    // a means of finding an augmenting path.
    @Override
    public void solve() {

        // Find max flow by adding all augmenting path flows.
        for (long f = dfs(s, INF); f != 0; f = dfs(s, INF)) {
            markAllNodesAsUnvisited();
            maxFlow += f;
        }
    }

    private long dfs(int node, long flow) {
        // Tại đỉnh đích, trả về flow
        if (node == t) return flow;

        List<Edge> edges = graph[node];
        visit(node);

        for (Edge edge : edges) {
            long rcap = edge.remainingCapacity();
            if (rcap > 0 && !visited(edge.to)) {
                long bottleNeck = dfs(edge.to, min(flow, rcap));

                // Augment flow with bottleneck value
                if (bottleNeck > 0) {
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }
}
