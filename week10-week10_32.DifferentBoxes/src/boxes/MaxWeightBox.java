package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {

    private int maxBoxWeight;
    private List<Thing> boxOfThings;

    public MaxWeightBox(int maxWeight) {
        this.maxBoxWeight = maxWeight;
        this.boxOfThings = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        int weightBox = 0;
        for (Thing t : boxOfThings) {
            weightBox += t.getWeight();
        }
        if (weightBox + thing.getWeight() <= this.maxBoxWeight) {
            boxOfThings.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return boxOfThings.contains(thing);
    }
}