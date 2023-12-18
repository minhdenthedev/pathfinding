package Dijkstra;

public class Vertex implements Comparable<Vertex>{
    String place;
    double distance;
    double capacity;

    // Head of the LinkedList
    public Vertex(String place) {
        this.place = place;
        distance = capacity = 0.0;
    }

    public Vertex(String place, double distance, double capacity) {
        this.place = place;
        this.distance = distance;
        this.capacity = capacity;
    }

    public Vertex(String place, double distance) {
        this.place = place;
        this.distance = distance;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "(" + place + ", " + distance + ", " + capacity + ")";
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance <= o.distance) return -1;
        else return 1;
    }
}