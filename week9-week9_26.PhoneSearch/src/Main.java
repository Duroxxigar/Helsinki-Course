import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        ContactBook contactBook = new ContactBook(reader);
        String input;

        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
        System.out.println();

        while (true) {

            System.out.print("command: ");

            input = reader.nextLine();

            switch (input) {
                case "1":
                    contactBook.addNumber();
                    break;
                case "2":
                    contactBook.searchForNumber();
                    break;
                case "3":
                    contactBook.searchByNumber();
                    break;
                case "4":
                    contactBook.addAddress();
                    break;
                case "5":
                    contactBook.searchForInformation();
                    break;
                case "6":
                    contactBook.deleteInformation();
                    break;
                // TODO: Implement this method
//                case "7":
//                    contactBook.filteredListing();
//                    break;
                case "x":
                    break;
            }
            if (input.toLowerCase().equals("x")) {
                break;
            }
            System.out.println();
        }
    }
}