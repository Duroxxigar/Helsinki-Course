package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{

    private int maximumCapacity;
    private List<Thing> items;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        items = new ArrayList<>();
    }

    public boolean addThing(Thing thing) {

        if (this.getVolume() + thing.getVolume() <= maximumCapacity) {
            items.add(thing);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (int i = 0, j = items.size(); i < j; i++) {
            totalVolume += items.get(i).getVolume();
        }
        return totalVolume;
    }
}
