package leetcode.bitwise;

public class BitwiseXor {

    /*
        // XOR - 1 ^ 1 = 0
        // XOR - 0 ^ 0 = 0
        // XOR - 1 ^ 0 = 1
        // XOR - 0 ^ 1 = 1
     */
    public static void main(String[] args) {
        basicXor();
    }

    private static void basicXor() {
        // 1001 ^ 0110 = 1111
        XOR("1001", "0110");

        // 1001 ^ 1001 = 0000
        XOR("1001", "1001");

        // x ^ 0 = x
        XOR("1001", "0000");

        // x ^ 1 = ~x  (All bits flipped)
        XOR("1001", "1111");

        // x ^ x = 0
        XOR("1001", "1001");
    }



    private static void XOR(String s1, String s2) {
        int x = Integer.parseInt(s1, 2);
        int y = Integer.parseInt(s2, 2);
        int result = x ^ y;
        String resultS3 = Integer.toBinaryString(result);
        System.out.println(s1 + " ^ " + s2 + " = " + resultS3);
        System.out.println(x + " ^ " + y + " = " + result);
        System.out.println("====================================");
    }
}
