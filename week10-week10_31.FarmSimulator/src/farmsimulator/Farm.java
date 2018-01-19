package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private final String owner;
    private final Barn barn;
    private final List<Cow> cowsInBarn;

    public Farm(String ownerName, Barn ownerBarn) {
        this.owner = ownerName;
        this.barn = ownerBarn;
        this.cowsInBarn = new ArrayList<Cow>();
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public void liveHour() {
        for (Cow c : cowsInBarn) {
            c.liveHour();
        }
    }

    public void manageCows() {
        this.barn.takeCareOf(cowsInBarn);
    }

    public void addCow(Cow cow) {
        this.cowsInBarn.add(cow);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        String title = "Farm owner: " + this.owner + "\n"
                + "Barn bulk tank: " + this.barn.toString() + "\n"
                + "Animals:" + "\n";
        for (Cow c : cowsInBarn) {
            title += "        " + c.toString() + "\n";
        }
        return title;
    }
}