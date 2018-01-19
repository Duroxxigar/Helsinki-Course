import java.util.*;

public class TextUI {

    private Scanner reader;
    private List<Jumper> jumperInfo;

    public TextUI(Scanner reader) {
        this.reader = reader;
        jumperInfo = new ArrayList<>();
    }

    public void entryScreen() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.print("Write the names of the participants one at a time; ");
        System.out.println("an empty string brings you to the jumping phase.");
        String input;
        do {
            System.out.print("  Participant name: ");
            input = reader.nextLine();
            if (input.isEmpty()) {
                break;
            }
            jumperInfo.add(new Jumper(input, 0));
        } while (true);

        System.out.println();
    }

    public void tournamentScreen() {
        int roundCount = 1;
        System.out.println("The tournament begins!");
        System.out.println();
        do {
            System.out.println("Write \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            if (!input.equalsIgnoreCase("jump")) {
                return;
            }
            System.out.println("Round " + roundCount);
            System.out.println();
            System.out.println("Jumping order: ");
            Collections.sort(jumperInfo);
            for (int i = 1; i < jumperInfo.size() + 1; i++) {
                System.out.println("   " + i + ". " + jumperInfo.get(i - 1));
            }
            System.out.println();

            System.out.println("Results of round " + roundCount);
            for (int i = 0; i < jumperInfo.size(); i++) {
                int jumpLength = jumperInfo.get(i).jumpLength();

                List<Integer> judgeVotes = new ArrayList<>();
                judgeVotes.addAll(jumperInfo.get(i).judgePoint());

                System.out.println("  " + jumperInfo.get(i).getName());
                System.out.println("    length: " + jumpLength);
                System.out.println("    judge votes: " + judgeVotes);

                int points = jumperInfo.get(i).calculatePoints(jumpLength, judgeVotes);
                jumperInfo.get(i).addPoints(points);
            }
            System.out.println();
            roundCount++;
        } while (true);
    }

    public void finalScreen() {
        System.out.println("Thanks!");
        System.out.println();
        System.out.println("Tournament results: ");
        System.out.println("Position    Name");
        Collections.sort(jumperInfo);
        Collections.reverse(jumperInfo);
        for (int i = 1; i < jumperInfo.size() + 1; i++) {
            System.out.println(i + "           " + jumperInfo.get(i - 1).toString());
            jumperInfo.get(i - 1).printJumps();
        }
    }
}