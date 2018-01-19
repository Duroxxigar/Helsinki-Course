package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {

    private List<Movable> organismList;

    public Group() {
        organismList = new ArrayList<>();
    }

    public void addToGroup(Movable movable) {
        organismList.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable organism : organismList) {
            organism.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String print = "";
        for (Movable organism : organismList) {
            print += organism.toString();
            print += '\n';
        }
        return print;
    }
}