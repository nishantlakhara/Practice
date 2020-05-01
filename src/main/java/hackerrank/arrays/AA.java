package hackerrank.arrays;

import java.util.HashMap;
import java.util.Map;

public class AA {
    public static void main(String[] args) {
        String myString = "One Two Three";

        char[] c = new char[myString.length()];

        int j = myString.length() - 1;
        for(int i=0; i<myString.length(); i++) {
            c[i] = myString.charAt(j);
            j--;
        }

        String s = String.valueOf(c);
        System.out.println(s);

        Map map = new HashMap<>();
    }
}
