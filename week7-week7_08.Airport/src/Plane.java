import java.util.ArrayList;

public class Plane {

    private String planeID;
    private int capacity;
    private ArrayList<Flight> flights;

    public Plane(String planeID) {
        this.planeID = planeID;
        flights = new ArrayList<>();
    }

    public void addFlight(String departure, String destination) {
        Flight flight = new Flight(departure, destination);
        flights.add(flight);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void printFlight(int i) {
        for (i = 0; i < flights.size(); i++) {
            System.out.print(this.toString());
            System.out.println(flights.get(i).printString());
        }
    }

    public String toString() {
        return planeID + " (" + capacity + " ppl)";
    }
}