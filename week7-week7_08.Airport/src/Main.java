import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        AirportPanel airportPanel = new AirportPanel(reader);
        FlightService flightService = new FlightService(reader, airportPanel);

        airportPanel.start();
        flightService.start();
    }
}