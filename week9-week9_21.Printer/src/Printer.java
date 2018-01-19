import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Printer {

    private List<String> linesList;

    public Printer(String fileName) throws Exception {
        Scanner fileInput = new Scanner(new File(fileName));
        linesList = new ArrayList<>();

        while (fileInput.hasNextLine()) {
            linesList.add(fileInput.nextLine());
        }
    }

    public void printLinesWhichContain(String word) throws Exception {
        for (String line : linesList) {
            if (word.isEmpty() || line.contains(word)) {
                System.out.println(line);
            }
        }
    }
}
