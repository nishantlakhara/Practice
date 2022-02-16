package subset;

import java.util.Arrays;

public class SubsetUtilites {
    public static void main(String[] args) {
        subArrayFromArray();

        splitAString();
    }

    private static void splitAString() {
        String s = "a.bc+g@gmail.com";
        String[] split = s.split("@");
        for(String ss: split) {
            System.out.println(ss);
        }

        String[] split1 = split[0].split("\\+");
        for(String ss: split1) {
            System.out.println(ss);
        }

        String local = split1[0].replace(".","");
        System.out.println(local + "@" + split[1]);
    }

    private static void subArrayFromArray() {
        //Create subarray
        int[] ints = new int[] {1,2,3,4,5,6,7,8};
        int[] ints1 = Arrays.copyOfRange(ints, 1, 5);
        for(int i: ints1) {
            System.out.println(i);
        }
    }
}
