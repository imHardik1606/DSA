import java.util.HashMap;

public class hashMap {
    public static void main(String[] args) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 120);
        hm.put("China", 100);
        hm.put("US", 50);

        System.out.println(hm);

        // //Get
        // int population  = hm.get("India");
        // System.out.println(population);

        // System.out.println(hm.get("Indonesia"));

        // //ContainsKey
        // System.out.println(hm.containsKey("Indonesia"));

        //Remove
        hm.remove("Indo");
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //isEmpty
        System.out.println(hm.isEmpty());

        //clear
        hm.clear();
        System.out.println(hm.isEmpty());
    }
}