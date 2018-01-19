package farmsimulator;

public class BulkTank {

    private double capacity, volume;

    public BulkTank() {
        this.capacity = 2000;
        this.volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }

    public void addToTank(double amount) {
        if (amount + volume > capacity) {
            volume = capacity;
        } else {
            volume += amount;
        }
    }

    public double getFromTank(double amount) {
        if (volume - amount < 0) {
            volume = 0;
            return volume;
        } else {
            volume -= amount;
            return volume;
        }
    }

    @Override
    public String toString() {
        return Math.ceil(getVolume()) + "/" + Math.ceil(getCapacity());
    }

}
