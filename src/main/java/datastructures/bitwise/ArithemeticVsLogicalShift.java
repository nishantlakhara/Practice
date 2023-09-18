package datastructures.bitwise;

public class ArithemeticVsLogicalShift {
    public static void main(String[] args) {
        // Arithmetic shift
        repeatedArithmeticShift(100, 10);
        repeatedLogicalShift(100, 10);

        repeatedArithmeticShift(-100, 10);
        repeatedLogicalShift(-100, 10);
    }

    public static int repeatedArithmeticShift(int x, int count) {
        System.out.println("\nrepeatedArithmeticShift *************");
        System.out.println("initially x = " + x);
        for(int i=0; i<count; i++) {
            x = x >> 1;
            System.out.println("x = x >> 1 is " + x);
        }
        return x;
    }

    public static int repeatedLogicalShift(int x, int count) {
        System.out.println("\nrepeatedLogicalShift *************");
        System.out.println("initially x = " + x);
        for(int i=0; i<count; i++) {
            x = x >>> 1;
            System.out.println("x = x >>> 1 is " + x);
        }
        return x;
    }
}
