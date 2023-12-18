package data;

import object.FordFulkersonDfsSolverAdjacencyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * reading the provided data sets and convert it into a list of vertex object
 */

public class ImportData {

    static FordFulkersonDfsSolverAdjacencyList graph;
    static int n;
    public static FordFulkersonDfsSolverAdjacencyList getGraphFromDataSet() {

        String dataSetName = "location.csv";
        String line = "";
        String splitBy = ",";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dataSetName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = line.split(splitBy);
                int from = Integer.parseInt(temp[0]);
                int to = Integer.parseInt(temp[1]);
                double distance = Double.parseDouble(temp[2]);
                long capacity = Long.parseLong(temp[3]);
                graph.addEdge(from, to, distance, capacity);
                n++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

    public int getN() {
        return n;
    }
}
