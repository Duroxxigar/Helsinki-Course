import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> playerHand;

    public Hand() {
        playerHand = new ArrayList<>();
    }

    public void add(Card card) {
        playerHand.add(card);
    }

    public void print() {
        for (int i = 0, j = playerHand.size(); i < j; i++) {
            System.out.println(playerHand.get(i));
        }
    }

    public void sort() {
        Collections.sort(this.playerHand);
    }

    @Override
    public int compareTo(Hand card) {
        int sum = 0;
        for (Card item : card.playerHand) {
            sum += item.getValue();
        }

        int sumTwo = 0;
        for (Card item : this.playerHand) {
            sumTwo += item.getValue();
        }
        return sumTwo - sum;
    }

    public void sortAgainstSuit(){
        SortAgainstSuitAndValue suitSorter = new SortAgainstSuitAndValue();
        Collections.sort(this.playerHand, suitSorter);
    }
}