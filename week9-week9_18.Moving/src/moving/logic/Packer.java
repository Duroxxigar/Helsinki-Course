package moving.logic;

import moving.domain.Thing;
import moving.domain.Box;

import java.util.ArrayList;
import java.util.List;

public class Packer {

    private int boxesVolume;
    private List<Box> boxes;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        boxes = new ArrayList<>();
    }

    public List<Box> packThings(List<Thing> things) {
        Box box = new Box(this.boxesVolume);
        for (Thing stuff: things) {
            box.addThing(stuff);
            boxes.add(box);
        }
        return boxes;
    }
}
