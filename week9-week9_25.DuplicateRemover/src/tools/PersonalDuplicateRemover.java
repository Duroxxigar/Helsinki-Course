package tools;

import java.util.HashSet;
import java.util.Set;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private int detectedDuplicates;
    private Set<String> storedStrings;

    public PersonalDuplicateRemover() {
        detectedDuplicates = 0;
        storedStrings = new HashSet<>();
    }

    @Override
    public void add(String characterString) {
        if (storedStrings.contains(characterString)) {
            detectedDuplicates++;
        } else {
            storedStrings.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return detectedDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        if (!storedStrings.isEmpty()) {
            return storedStrings;
        }
        return storedStrings;
    }

    @Override
    public void empty() {
        storedStrings.clear();
        detectedDuplicates = 0;
    }
}
