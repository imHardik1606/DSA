import java.util.HashMap;
import java.util.TreeMap;

public class TreeM {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Azerbhaijan", 12);

        System.out.println(tm);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Azerbhaijan", 12);

        System.out.println(hm);
    }
}
