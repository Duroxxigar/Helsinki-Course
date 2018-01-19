import java.util.HashMap;
import java.util.Scanner;

public class AirportPanel {

    private Scanner reader;
    private HashMap<String, Plane> planeHashMap;

    public AirportPanel(Scanner reader) {
        this.reader = reader;
        planeHashMap = new HashMap<>();
    }

    public void start() {
        Plane plane;
        int numberInput;
        String input;

        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
        do {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            input = reader.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Give plane ID: ");
                    input = reader.nextLine();

                    System.out.print("Give plane capacity: ");
                    numberInput = Integer.parseInt(reader.nextLine());

                    plane = new Plane(input);
                    plane.setCapacity(numberInput);
                    planeHashMap.put(input, plane);
                    break;
                case "2":
                    System.out.println("Give plane ID: ");
                    input = reader.nextLine();

                    if (planeHashMap.containsKey(input)) {
                        System.out.print("Give departure airport code: ");
                        String depart = reader.nextLine();
                        System.out.print("Give destination airport code: ");
                        String destination = reader.nextLine();
                        planeHashMap.get(input).addFlight(depart, destination);
                    } else {
                        System.out.println("The plane does not exist.");
                    }
                    break;
                default:
                    break;
            }
        }
        while (!input.equals("x"));
    }

    public HashMap<String, Plane> getPlaneHashMap() {
        return planeHashMap;
    }
}