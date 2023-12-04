package graphdata;

import java.util.LinkedList;

public class AdjacentListGraph {
    LinkedList<LinkedList<Vertex>> adjacentList;
    public AdjacentListGraph() {
        adjacentList = new LinkedList<>();
    }

    public void addVertex(String place) {
        // If the place already exist, return nothing
        for (LinkedList<Vertex> link : adjacentList) {
            if (link.get(0).getPlace().equals(place)) return;
        }
        // Add new place
        LinkedList<Vertex> link = new LinkedList<>();
        link.add(new Vertex(place));
        adjacentList.add(link);
    }

    // Add edges between u and v
    public void addEdges(String u, double distance, double capacity, String v) {
        for (LinkedList<Vertex> link : adjacentList) {
            if (link.get(0).getPlace().equals(u)) {
                Vertex destination = new Vertex(v, distance, capacity);
                link.add(destination);
            }
            if (link.get(0).getPlace().equals(v)) {
                Vertex destination = new Vertex(u, distance, capacity);
                link.add(destination);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Vertex> link : adjacentList) {
            for (Vertex v : link) {
                sb.append(v.getPlace());
                sb.append("   ");
            }
            sb.append("\n");
            for (Vertex v : link) {
                if (v.getDistance() == 0) {
                    sb.append("  ");
                } else {
                    sb.append(v.getDistance());
                    sb.append(" ");
                }
            }
            sb.append("\n");
            for (Vertex v : link) {
                if (v.getCapacity() == 0) {
                    sb.append("  ");
                } else {
                    sb.append(v.getCapacity());
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
