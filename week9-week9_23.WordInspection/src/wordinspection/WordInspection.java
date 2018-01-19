package wordinspection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

    private File file;
    private final String vowels = "aeiouyäö";

    public WordInspection(File file) {
        this.file = file;
    }


    public int wordCount() {
        Scanner reader = readFile();
        int count = 0;

        while (reader.hasNextLine()) {
            String file = reader.nextLine();
            count++;
        }
        reader.close();
        return count;
    }

    public List<String> wordsContainingZ() {
        List<String> listOfZ = new ArrayList<>();
        Scanner reader = readFile();

        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            if (word.toLowerCase().contains("z")) {
                listOfZ.add(word);
            }
        }
        reader.close();
        return listOfZ;
    }

    public List<String> wordsEndingInL() {
        List<String> listOfL = new ArrayList<>();
        Scanner reader = readFile();

        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            if (word.toLowerCase().endsWith("l")) {
                listOfL.add(word);
            }
        }
        reader.close();
        return listOfL;
    }

    public List<String> palindromes() {
        List<String> palindromeList = new ArrayList<>();
        Scanner reader = readFile();

        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            String reverse = reverseString(word);

            if (word.equalsIgnoreCase(reverse)) {
                palindromeList.add(word);
            }
        }
        reader.close();
        return palindromeList;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> vowelList = new ArrayList<>();
        Scanner reader = readFile();

        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            if (containsAllVowels(s)) {
                vowelList.add(s);
            }
        }
        reader.close();
        return vowelList;
    }

    private String reverseString(String stringToReverse) {
        StringBuilder string = new StringBuilder(stringToReverse);
        return string.reverse().toString();
    }

    private Scanner readFile() {
        Scanner reader = null;

        try {
            reader = new Scanner(file, "UTF-8");
            return reader;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private boolean containsAllVowels(String word) {
        for (char vowel: this.vowels.toCharArray()) {
            if (!word.contains("" + vowel)) {
                return false;
            }
        }
        return true;
    }
}