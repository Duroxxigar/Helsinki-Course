import java.util.List;
import java.util.Map;

public class Util {

    public static Object getKeyFromValue(Map mapToSearch, Object valueToLookFor) {
        for (Object o : mapToSearch.keySet()) {
            if (mapToSearch.get(o).equals(valueToLookFor)) {
                return o;
            }
        }
        return null;
    }

    public static void printAddressPretty(List listToPrint) {
        for (int i = 0, n = listToPrint.size(); i < n; i++) {
            System.out.print(" " + listToPrint.get(i) + " ");
        }
        System.out.println();
    }
}