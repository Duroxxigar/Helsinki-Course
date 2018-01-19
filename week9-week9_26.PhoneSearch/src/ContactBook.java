import java.util.*;

public class ContactBook {

    private Map<String, List<String>> nameAndNumberList;
    private Map<String, List<String>> nameAndAddressList;
    private Scanner reader;

    public ContactBook(Scanner reader) {
        nameAndAddressList = new HashMap<>();
        nameAndNumberList = new HashMap<>();
        this.reader = reader;
    }

    public void addNumber() {

        System.out.print("whose number: ");
        String nameInput = reader.nextLine();
        System.out.print("number: ");
        String numberInput = reader.nextLine();

        if (!nameAndNumberList.containsKey(nameInput)) {
            nameAndNumberList.put(nameInput, new ArrayList<>());
        }
        nameAndNumberList.get(nameInput).add(numberInput);
    }

    public void searchForNumber() {

        System.out.print("whose number: ");
        String nameInput = reader.nextLine();

        if (!nameAndNumberList.containsKey(nameInput)) {
            System.out.println(" not found");
            return;
        }
        for (String numbers : nameAndNumberList.get(nameInput)) {
            System.out.println(" " + numbers);
        }
    }

    public void searchByNumber() {

        System.out.print("number: ");
        String numberInput = reader.nextLine();

        for (Map.Entry<String, List<String>> entry : nameAndNumberList.entrySet()) {
            List<String> value = entry.getValue();
            if (value.contains(numberInput)) {
                System.out.println(entry.getKey());
                break;
            } else {
                System.out.println(" not found");
            }
        }
    }

    public void addAddress() {

        System.out.print("whose address: ");
        String nameInput = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();

        if (!nameAndAddressList.containsKey(nameInput)) {
            nameAndAddressList.put(nameInput, new ArrayList<>());
        }
        nameAndAddressList.get(nameInput).add(street);
        nameAndAddressList.get(nameInput).add(city);
    }

    // TODO: Why the fuck is this not displaying properly on the automated tests?
    public void searchForInformation() {

        System.out.print("whose information: ");
        String nameInput = reader.nextLine();

        if (nameAndAddressList.get(nameInput) == null) {
            System.out.println(" address unknown");
        } else {
            System.out.print(" address: ");
            Util.printAddressPretty(nameAndAddressList.get(nameInput));
        }
        if (nameAndNumberList.get(nameInput) == null) {
            System.out.println(" phone number not found");
        } else {
            System.out.println(" phone numbers:");
            for (String numbers : nameAndNumberList.get(nameInput)) {
                System.out.println(" " + numbers);
            }
        }
    }

    public void deleteInformation() {
        System.out.print("whose information");
        String nameInput = reader.nextLine();

        nameAndNumberList.remove(nameInput);
        nameAndAddressList.remove(nameInput);
    }
}