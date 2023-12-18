package Dijkstra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AdjacentListGraph {
    LinkedList<LinkedList<Vertex>> adjacentList;
    int numOfVertices = 0;
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
        numOfVertices++;
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

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public int findLinkIndexInAdjacentMatrix(String s) {
        LinkedList<Vertex> link = new LinkedList<>();
        for (LinkedList<Vertex> l : adjacentList) {
            if (l.get(1).getPlace().equals(s)) {
                link = l;
                break;
            }
        }

        return adjacentList.indexOf(link);
    }

    public LinkedList<Vertex> getLink(String s) {
        for (LinkedList<Vertex> l : adjacentList) {
            if (l.get(0).getPlace().equals(s)) {
                return l;
            }
        }

        return null;
    }

    public ArrayList<String> findShortestPath(String origin, String destination) {
        ArrayList<String> path = new ArrayList<>();
        boolean[] visited = new boolean[numOfVertices];
        HashMap<String, Vertex> map = new HashMap<>();
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        map.put(origin, new Vertex(origin, 0.0));
        queue.add(new Vertex(origin, 0.0));

        while (!queue.isEmpty()) {
            Vertex temp = queue.poll();
            String v = temp.getPlace();
            double distance = temp.getDistance();
            visited[findLinkIndexInAdjacentMatrix(v)] = true;

            LinkedList<Vertex> link = getLink(v);
            for (Vertex next : link) {
                if (!visited[adjacentList.indexOf(getLink(next.getPlace()))]) {
                    if (!map.containsKey(next.getPlace())) {
                        map.put(next.getPlace(), new Vertex(v, distance + next.getDistance()));
                    } else {
                        Vertex sn = map.get(next.getPlace());
                        if (distance + next.getDistance() < sn.getDistance()) {
                            sn.setPlace(v);
                            sn.setDistance(distance + next.getDistance());
                        }
                    }
                    queue.add(new Vertex(next.getPlace(), distance + next.getDistance()));
                }
            }
        }
        path.add(destination);
        while (!path.get(0).equals(origin)) {
            String temp = map.get(path.get(0)).getPlace();
            path.add(0, temp);
        }

        return path;
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