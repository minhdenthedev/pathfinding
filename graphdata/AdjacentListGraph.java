package graphdata;

import java.util.LinkedList;

public class AdjacentListGraph {
    LinkedList<LinkedList<Vertex>> adjacentList;
    public AdjacentListGraph() {
        adjacentList = new LinkedList<>();
    }

    public void addVertex(String place) {
        LinkedList<Vertex> link = new LinkedList<>();
        link.add(new Vertex(place));
        adjacentList.add(link);
    }

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
}
