package datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    private static final int MAX_ENTRIES = 5;

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer,
                String>(MAX_ENTRIES + 1, .75F, false) {
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > MAX_ENTRIES;
            }
        };
        lhm.put(0, "H");
        lhm.put(1, "E");
        lhm.put(2, "L");
        lhm.put(3, "L");
        lhm.put(4, "O");
        lhm.put(3, "H");


        for(Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("" + lhm);
    }
}
