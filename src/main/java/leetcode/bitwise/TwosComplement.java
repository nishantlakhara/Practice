package leetcode.bitwise;

public class TwosComplement {
    public static void main(String[] args) {
        twosComplementRepresentation(-3);

        twosComplement(7);
        twosComplement(Integer.MAX_VALUE);

    }

    private static void twosComplement(int num) {
        System.out.println("\n******************************************************************twosComplement*****************************************");

        // For 4 bits
        // 7 - 0111,  -1 - 1111, -7 - 1001
        // 6 - 0110,  -2 - 1110, -6 - 1010

        // For 32 bits
        System.out.println("Twos complement of " + num + "(" + Integer.toBinaryString(num) + ") is "
                + (~num + 1) + "(" + Integer.toBinaryString(~num + 1) + ")");
    }

    private static void twosComplementRepresentation(int k) {
        // 2s complement = Negative number -K represented as concat (1 , 2^(N-1) - K)
        System.out.println("\n******************************************************************twosComplementRepresentation*****************************************");
        int TwopowNMinus1Minusk = (int) Math.pow(2, 31) - (-k);
        System.out.println(Integer.toBinaryString(k) + " = concat(" + 1 + "," + Integer.toBinaryString(TwopowNMinus1Minusk) + ") = \n1(sign)" + Integer.toBinaryString(1 + TwopowNMinus1Minusk));
        System.out.println("2 pow 31 - 1 = " + Integer.MAX_VALUE + " Integer max value = " + Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("-2 pow 31    = " + Integer.MIN_VALUE + " Integer min value = " + Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
