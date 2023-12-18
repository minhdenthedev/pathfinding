package object;


import java.util.ArrayList;
import java.util.List;

public abstract class NetworkFlowSolverBase {

    // Để tránh overflow, gán giá trị vô cực nhỏ hơn Long.MAX_VALUE
    protected static final long INF = Long.MAX_VALUE / 2;

    // Inputs: n = tổng số lượng node, s = đỉnh nguồn, t = đỉnh đích
    protected int n, s, t;
    protected long maxFlow;

    protected List<Edge>[] graph;
    private int visitedToken = 1;
    private int[] visited;
    private boolean solved;

    public NetworkFlowSolverBase(int n, int s, int t) {
        this.n = n;
        this.s = s;
        this.t = t;
        initializeGraph();
        visited = new int[n];
    }

    public NetworkFlowSolverBase() {
    }

    // Construct an empty graph with n nodes including the source and sink nodes.
    @SuppressWarnings("unchecked")
    private void initializeGraph() {
        graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<Edge>();
    }

    /**
     * Adds a directed edge (and residual edge) to the flow graph.
     *
     * @param from     - The index of the node the directed edge starts at.
     * @param to       - The index of the node the directed edge ends at.
     * @param capacity - The capacity of the edge.
     */
    public void addEdge(int from, int to, double distance, long capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity < 0");
        Edge e1 = new Edge(from, to, capacity);
        Edge e2 = new Edge(to, from, 0);
        e1.residual = e2;
        e2.residual = e1;
        graph[from].add(e1);
        graph[to].add(e2);
    }

    public int getTotalEdge() {
        int totalLength = 0;
        for (int i = 0; i < graph.length; i++) {
            totalLength += graph[i].size();
        }
        return totalLength / 2;
    }

    // Marks node 'i' as visited.
    public void visit(int i) {
        visited[i] = visitedToken;
    }

    // Returns whether node 'i' has been visited.
    public boolean visited(int i) {
        return visited[i] == visitedToken;
    }

    // Resets all nodes as unvisited. This is especially useful to do
    // between iterations of finding augmenting paths, O(1)
    public void markAllNodesAsUnvisited() {
        visitedToken++;
    }

    /**
     * Returns the graph after the solver has been executed. This allows you to inspect the {@link
     * Edge#flow} compared to the {@link Edge#capacity} in each edge. This is useful if you want to
     * figure out which edges were used during the max flow.
     */
    public List<Edge>[] getGraph() {
        execute();
        return graph;
    }

    // Returns the maximum flow from the source to the sink.
    public long getMaxFlow() {
        execute();
        return maxFlow;
    }

    // Wrapper method that ensures we only call solve() once
    private void execute() {
        if (solved) return;
        solved = true;
        solve();
    }

    // Method to implement which solves the network flow problem.
    public abstract void solve();
}