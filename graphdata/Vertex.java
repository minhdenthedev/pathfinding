package graphdata;

public class Vertex {
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
}
