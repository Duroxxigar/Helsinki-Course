package boxes;

import java.util.ArrayList;
import java.util.List;

public class BlackHoleBox extends Box {

    private List<Thing> blackHoleBox;

    public BlackHoleBox() {
        blackHoleBox = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        blackHoleBox.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }

}