package object;

public class Vertex implements Comparable<Vertex> {

    /**
     *
     */
    private final String name;
    private double distance;
    private double capacity;

    /* Constructor method */

    public Vertex(String name, double distance, double capacity) {
        this.name = name;
        this.distance = distance;
        this.capacity = capacity;
    }

    public Vertex(String name) {
        this.name = name;
    }
    /* Getter method */

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "(" + getName() + ", " + getDistance() + ", " + getCapacity() + ")";
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.distance <= o.distance) return -1;
        return 1;
    }
}