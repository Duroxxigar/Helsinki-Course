import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> basketMap;

    public ShoppingBasket() {
        basketMap = new HashMap<>();
    }

    public void add(String product, int price) {
        if (!basketMap.containsKey(product)) {
            Purchase item = new Purchase(product, 1, price);
            basketMap.put(product, item);
        } else {
            basketMap.get(product).increaseAmount();
        }
    }

    public int price() {
        List<Purchase> items = new ArrayList<>(basketMap.values());
        int sum = 0;
        for (int i = 0, n = items.size(); i < n; i++) {
            sum += items.get(i).price();
        }
        return sum;
    }

    public void print() {
        List<Purchase> items = new ArrayList<>(basketMap.values());

        for (int i = 0, n = items.size(); i < n; i++) {
            System.out.println(items.get(i));
        }
    }
}
