import java.util.ArrayList;

public class Suitcase {

    private int weightLimit;
    private ArrayList<Thing> things;

    public Suitcase(int maxWeight) {
        this.weightLimit = maxWeight;
        this.things = new ArrayList<>();
    }

    public void addThing(Thing thing) {
        int total = 0;
        for (int i = 0; i < things.size(); i++) {
            total += things.get(i).getWeight();
        }
        if (total <= weightLimit && total + thing.getWeight() <= weightLimit) {
            things.add(thing);
        }
    }

    public String toString() {
        int total = 0;
        for (int i = 0; i < things.size(); i++) {
            total += things.get(i).getWeight();
        }
        if (things.size() == 0) {
            return "empty (" + total + " kg)";
        } else if (things.size() == 1) {
            return things.size() + " thing (" + total + " kg)";
        }
        return things.size() + " things (" + total + " kg)";
    }

    public void printThings() {
        for (Thing list : things) {
            System.out.println(list);
        }
    }

    public int totalWeight() {
        int total = 0;
        for (int i = 0; i < things.size(); i++) {
            total += things.get(i).getWeight();
        }
        return total;
    }

    public Thing heaviestThing() {
        Thing heaviest = null;
        for (int i = 0; i < things.size() - 1; i++) {
            if (things.get(i).getWeight() > things.get(i + 1).getWeight()) {
                heaviest = things.get(i);
            } else {
                heaviest = things.get(i + 1);
            }
            if (things.isEmpty()) {
                return null;
            }
        }
        return heaviest;
    }
}