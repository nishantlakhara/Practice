package datastructures.bitwise;

public class BitwiseOperationsSheet {
    public static void main(String[] args) {
        AND();
        OR();
        NOT();
        XOR();
        LEFT_SHIFT();
        TRICK_CHECK_EVEN();
    }

    public static void TRICK_CHECK_EVEN() {
        int x=5;

        if((x & 1) == 0) {
            System.out.println("Number " + x + " is even.");
        } else {
            System.out.println("Number " + x + " is odd.");
        }
    }

    public static void AND() {
        int x = 12;
        int y = 10;
        System.out.println("Bitwise AND of (" + x + " , " + y + ") is: " + (x & y)); // yields to 8
    }

    public static void OR() {
        int x = 12;
        int y = 10;
        System.out.println("Bitwise OR of " + x + ", " + y + " is: " + helper(x, y)); // yields to 14
    }

    public static void XOR() {
        int x = 12;
        int y = 10;
        System.out.println("Bitwise XOR of (x , y) is : " + (x ^ y)); // yields to 6
    }

    private static int helper(int x, int y) {
        return x | y;
    }

    /**
     * NOT x = 2pow(32)−x
     */
    public static void NOT() {
        int a = 1;
        System.out.println("Bitwise NOT of " + a + " is : " + ~a);
    }

    public static void LEFT_SHIFT() {
        int number = 100;
        System.out.println(number + " shifted 1 position left, yields to " + (number << 1));
        System.out.println(number + " shifted 2 positions left, yields to " + (number << 2));
        System.out.println(number + " shifted 3 positions left, yields to " + (number << 3));
        System.out.println(number + " shifted 4 positions left, yields to " + (number << 4));
    }
}
