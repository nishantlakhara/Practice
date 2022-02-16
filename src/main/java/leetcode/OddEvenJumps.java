package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class OddEvenJumps {
    public int oddEvenJumps(int[] a) {
        int n = a.length;
        boolean odd[] = new boolean[n], even[] = new boolean[n];
        odd[n-1] = even[n-1] = true;

        int cnt = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(a[n-1], n-1);

        for (int i=n-2;i>=0;i--) {
            System.out.println(map);

            System.out.println("Index =  " + i);
            Map.Entry<Integer, Integer> en = map.ceilingEntry(a[i]);
            System.out.println("Ceiling of " + a[i] + " = " + en);
            odd[i] = en == null ? false : even[en.getValue()];
            System.out.println("Odd(" + i + ") = " + odd[i]);

            en = map.floorEntry(a[i]);
            System.out.println("Floor of " + a[i] + " = " + en);
            even[i] = en == null ? false : odd[en.getValue()];
            System.out.println("Even(" + i + ") = " + even[i]);

            if (odd[i]) cnt++;

            map.put(a[i], i);
        }

        return cnt;
    }
}
