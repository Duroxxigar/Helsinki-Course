package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {

    private File file;

    public Analysis(File file) {
        try {
            this.file = file;
        } catch (Exception e) {
            System.out.println("No file to read. Error: " + e.getMessage());
        }
    }

    public int lines() {
        Scanner reader = null;
        int numberOfLines = 0;

        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return 0;
        }
        while (reader.hasNextLine()) {
            String string = reader.nextLine();
            numberOfLines++;
        }
        reader.close();
        return numberOfLines;
    }

    public int characters() {
        Scanner reader = null;
        int numberOfCharacters = lines();

        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return 0;
        }

        while (reader.hasNext()) {
            String line = reader.nextLine();
            numberOfCharacters += line.length();
        }
        reader.close();
        return numberOfCharacters;
    }
}
