package graphdata;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Path {
    AdjacentListGraph graph;
    int numOfPlaces;

    public Path(String csvFile) {
        graph = new AdjacentListGraph();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(splitBy);    // use comma as separator
                String u = temp[0];
                String v = temp[1];
                double distance = Double.parseDouble(temp[2]);
                double capacity = Double.parseDouble(temp[3]);
                graph.addVertex(u);
                graph.addVertex(v);
                graph.addEdges(u, distance, capacity, v);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getNumOfPlaces() {
        return graph.getNumOfVertices();
    }

    public ArrayList<String> shortestPath(String origin, String destination) {
        return graph.findShortestPath(origin, destination);
    }

    @Override
    public String toString() {
        return graph.toString();
    }
}
