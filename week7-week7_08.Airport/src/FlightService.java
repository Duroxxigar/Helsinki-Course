import java.util.ArrayList;
import java.util.Scanner;

public class FlightService {

    private Scanner reader;
    private AirportPanel airportPanel;

    public FlightService(Scanner reader, AirportPanel airportPanel) {
        this.reader = reader;
        this.airportPanel = airportPanel;
    }

    public void start() {
        String input;

        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println();
        do {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");

            input = reader.nextLine();

            switch (input) {
                case "1":
                    for (String key: airportPanel.getPlaneHashMap().keySet()) {
                        System.out.println(airportPanel.getPlaneHashMap().get(key).toString());
                    }
                    break;
                case "2":
                    ArrayList<String> keys = new ArrayList<>(airportPanel.getPlaneHashMap().keySet());

                    for (int i = 0, j = keys.size(); i < j; i++) {
                        String key = keys.get(i);
                        airportPanel.getPlaneHashMap().get(key).printFlight(i);
                    }
                    break;
                case "3":
                    System.out.print("Give plane ID: ");
                    input = reader.nextLine();
                    System.out.println(airportPanel.getPlaneHashMap().get(input));
                    break;
                default:
                    break;
            }
        } while (!input.equals("x"));
    }
}