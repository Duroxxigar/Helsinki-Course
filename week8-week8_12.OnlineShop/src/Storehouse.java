import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> productMapPrice;
    private Map<String, Integer> productMapStock;

    public Storehouse() {
        productMapPrice = new HashMap<>();
        productMapStock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        productMapPrice.put(product, price);
        productMapStock.put(product, stock);
    }

    public int price(String product) {
        if (!productMapPrice.containsKey(product)) {
            return -99;
        }
        return productMapPrice.get(product);
    }

    public int stock(String product) {
        if (!productMapStock.containsKey(product)) {
            return 0;
        }
        return productMapStock.get(product);
    }

    public boolean take(String product) {
        if (productMapStock.containsKey(product)) {
            int value = productMapStock.get(product);
            if (value > 0) {
                productMapStock.put(product, value - 1);
                return true;
            }
        }
        return false;
    }

    public Set<String> products() {
        return productMapStock.keySet();
    }
}
