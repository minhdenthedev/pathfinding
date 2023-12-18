/**
 * Thuật toán Ford-Fulkerson với thuật toán duyệt DFS để tìm một phần đồ thị (path). Ford-Fulkerson cho phép tìm luồng
 * cực đại (max flow) trên một đồ thị có hướng có trọng số, cũng như tìm lát cắt cực tiểu
 *
 * <p>Time Complexity: O(V^2)
 */

package object;

import java.util.List;

import static java.lang.Math.min;

public class FordFulkersonDfsSolverAdjacencyList extends SolverBase {


    public FordFulkersonDfsSolverAdjacencyList(int n, int s, int t) {
        super(n, s, t);
    }

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
