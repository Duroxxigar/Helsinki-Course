import java.util.*;

public class Jumper implements Comparable<Jumper> {

    private String name;
    private int points;
    private Random randomNumber;
    private List<Integer> jumps;

    public Jumper(String name, int points) {
        this.name = name;
        this.points = points;
        this.randomNumber = new Random();
        this.jumps = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints(int pointsToAdd) {
        this.points += pointsToAdd;
    }

    public int jumpLength() {
        int jump = randomNumber.nextInt(120 - 60 + 1) + 60;
        jumps.add(jump);
        return jump;
    }

    public List<Integer> judgePoint() {
        List<Integer> judgePoint = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int judgeScore = randomNumber.nextInt(20 - 10 + 1) + 10;
            judgePoint.add(judgeScore);
        }
        return judgePoint;
    }

    public int calculatePoints(int jumpLength, List<Integer> judgeScores) {
        int total = 0;

        removeSmallAndLarge(judgeScores);
        int sum = sumOfArray(judgeScores);

        total = jumpLength + sum;
        return total;
    }

    public int sumOfArray(List<Integer> scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public void removeSmallAndLarge(List<Integer> smallAndLargeRemoved) {
        Collections.sort(smallAndLargeRemoved);
        smallAndLargeRemoved.remove(0);
        smallAndLargeRemoved.remove(smallAndLargeRemoved.size() - 1);
    }

    public void printJumps() {
        System.out.print("            " + "jump lengths: ");
        for (int i = 0, n = jumps.size(); i < n; i++) {
            System.out.print(jumps.get(i));
            if (i < n - 1) {
                System.out.print(" m, ");
            } else {
                System.out.print(" m");
            }
        }
        System.out.println();
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.getPoints();
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }
}