public class Flight {

    private String depart;
    private String destination;

    public Flight(String depart, String destination) {
        this.depart = depart;
        this.destination = destination;
    }

    public String printString() {
        return " (" + depart + "-" + destination + ")";
    }
}