
import data.ImportData;
import object.Edge;
import object.FordFulkersonDfsSolverAdjacencyList;

import java.util.ArrayList;
import java.util.List;


public class Test {
    public static List<Edge> edgesFree = new ArrayList<>();
    static List<Edge> edgesMedium = new ArrayList<>();
    static List<Edge> edgesFullCapacity = new ArrayList<>();

    final static int n = ImportData.getN();
    final static int s = 0;
    final static int t = 25;

    public static void main(String[] args) {
        run_test();

        System.out.println(n);
        System.out.println("Free edges:");
        for (Edge e : edgesFree) {
            System.out.print(e.toStringOnlyVertex(s, t));
        }
        System.out.println();

        System.out.println("Medium edges:");
        for (Edge e : edgesMedium) {
            System.out.print(e.toStringOnlyVertex(s, t));
        }
        System.out.println();

        System.out.println("High edges:");
        for (Edge e : edgesFullCapacity) {
            System.out.print(e.toStringOnlyVertex(s, t));
        }
        System.out.println();
    }

    private static void run_test() {
        FordFulkersonDfsSolverAdjacencyList graph = ImportData.getFordFulkersonDfsSolverAdjacencyList(n, s, t);
        graph.getMaxFlow();
        System.out.println("Max flow:" + graph.getMaxFlow());

        List<Edge>[] g = graph.getGraph();

        for (List<Edge> edges : g) {
            for (Edge e : edges) {
                if (!e.isResidual()) {
                    if (e.flow >= 0 && e.flow < (e.capacity / 4)) {   /* list edge that have flow small */
                        edgesFree.add(e);
                    } else if (e.flow >= (e.capacity / 4) && e.flow < (e.capacity - e.capacity / 4)) {
                        edgesMedium.add(e);
                    } else {
                        edgesFullCapacity.add(e);
                    }
                }
            }
        }
    }
}
