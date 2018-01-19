import java.util.ArrayList;

public class Container {

    private int maxWeightLimit;
    private ArrayList<Suitcase> suitcases;

    public Container(int maxWeightLimit) {
        this.maxWeightLimit = maxWeightLimit;
        suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        int total = 0;
        for (int i = 0; i < suitcases.size(); i++) {
            total += suitcases.get(i).totalWeight();
        }
        if (total <= maxWeightLimit && total + suitcase.totalWeight() <= maxWeightLimit) {
            suitcases.add(suitcase);
        }
    }

    public String toString() {
        int total = 0;
        for (int i = 0; i < suitcases.size(); i++) {
            total += suitcases.get(i).totalWeight();
        }
        return suitcases.size() + " suitcases " + "(" + total + " kg)";
    }

    public void printThings() {
        for (Suitcase list : suitcases) {
            list.printThings();
        }
    }
}
