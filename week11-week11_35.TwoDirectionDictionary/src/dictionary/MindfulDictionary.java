package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author
 */
public class MindfulDictionary {

    private Map<String, String> dict = new HashMap<>();
    private String file;

    public MindfulDictionary() {

    }

    public MindfulDictionary(String file) {
        this.file = file;
    }

    public boolean load() {

        try {
            File f = new File(this.file);

            Scanner fileReader = new Scanner(f);

            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.dict.put(parts[0], parts[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean save() {

        FileWriter writer;
        try {
            writer = new FileWriter(file);
            for (String key : this.dict.keySet()) {
                writer.write(key + ":" + this.dict.get(key));
                writer.write("\n");
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void add(String word, String translation) {
        if (!this.dict.containsKey(word)) {
            this.dict.put(word, translation);
        }
    }

    public String translate(String word) {

        if (this.dict.containsKey(word)) {
            return this.dict.get(word);
        } else if (this.dict.containsValue(word)) {
            for (String key : this.dict.keySet()) {
                if (this.dict.get(key).equals(word)){
                    return key;
                }
            }
        }
        return null;
    }

    public void remove(String word) {
        if (this.dict.containsKey(word)) {
            this.dict.remove(word);
        }
        if (this.dict.containsValue(word)) {
            List<String> keys = new ArrayList<>();
            for (String key : this.dict.keySet()) {
                if (this.dict.get(key).equals(word)) {
                    keys.add(key);
                }
            }
            for (String k : keys) {
                this.dict.remove(k);
            }
        }
    }
} 