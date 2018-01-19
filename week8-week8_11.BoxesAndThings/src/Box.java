import java.util.ArrayList;

public class Box implements ToBeStored {

    private double maxWeight;
    private ArrayList<ToBeStored> itemsInBox;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        itemsInBox = new ArrayList<>();
    }

    public void add(ToBeStored itemToBeIncluded) {
        if (this.weight() + itemToBeIncluded.weight() <= maxWeight) {
            itemsInBox.add(itemToBeIncluded);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (ToBeStored item : itemsInBox) {
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + itemsInBox.size() + " things, total weight " + this.weight() + " kg";
    }
}
