package datastructures.bitwise;

public class CommonBitTasksGetSetClearUpdate {
    public static void main(String[] args) {
        getIthBit(43738473, 0);
        getIthBit(43738473, 1);
        getIthBit(43738473, 31);
        getIthBit(-43738473, 0);
        getIthBit(-43738473, 1);
        getIthBit(-43738473, 31);

        setIthBit(43738473, 31);
        setIthBit(43738473, 1);

        clearIthBit(-43738473, 31);
        clearIthBit(43738473, 0);
        clearIthBit(43738473, 10);

        clearMostSignificantToIthBit(43738473, 10);
        clearMostSignificantToIthBit(43738473, 11);

        clearZeroToIthBit(43738473, 10);

        updateBit(43738473, 10, 1);
        updateBit(43738473, 10, 0);

    }

    private static boolean getIthBit(int number, int i) {
        System.out.println("\n\n*******Get " + i + "th bit of " + number);
        String binaryString = Integer.toBinaryString(number);
        // System.out.println("Binary representation of number " + number + " is " + binaryString);
        int mask = 1 << i;
        System.out.println("Mask binary = " + Integer.toBinaryString(mask));
        boolean response = (number & mask) != 0;
        if(response == true) {
            System.out.println(i + "th bit of " + binaryString + " = "  + 1);
        } else {
            System.out.println(i + "th bit of " + binaryString + " = "  + 0);
        }
        return response;
    }

    private static int setIthBit(int number, int i) {
        System.out.println("\n\n*******Set " + i + "th bit of " + number);
        String binaryString = Integer.toBinaryString(number);
        // System.out.println("Binary representation of number " + number + " is " + binaryString);
        int mask = 1 << i;
        System.out.println("Mask binary = " + Integer.toBinaryString(mask));
        int response = number | mask;
        System.out.println("Number " + number + "(" + Integer.toBinaryString(number) + ") setting " + i + "th bit = " + response + "(" + Integer.toBinaryString(response) + ")");
        return response;
    }

    private static int clearIthBit(int number, int i) {
        System.out.println("\n\n*******Clear " + i + "th bit of " + number);
        String binaryString = Integer.toBinaryString(number);
        // System.out.println("Binary representation of number " + number + " is " + binaryString);
        int mask = ~(1 << i);
        System.out.println("Mask binary = " + Integer.toBinaryString(mask));
        int response = number & mask;
        System.out.println("Number " + number + "(" + Integer.toBinaryString(number) + ") Clearing " + i + "th bit = " + response + "(" + Integer.toBinaryString(response) + ")");
        return response;
    }

    private static int clearMostSignificantToIthBit(int number, int i) {
        System.out.println("\n\n*******clearMostSignificantToIthBit " + i + "th bit of " + number);
        String binaryString = Integer.toBinaryString(number);
        // System.out.println("Binary representation of number " + number + " is " + binaryString);
        int mask = 1 << i - 1;
        System.out.println("Mask binary = " + Integer.toBinaryString(mask));
        int response = number & mask;
        System.out.println("Number " + number + "(" + Integer.toBinaryString(number) + ") Clearing Most significant to " + i + "th bit = " + response + "(" + Integer.toBinaryString(response) + ")");
        return response;
    }

    private static int clearZeroToIthBit(int number, int i) {
        System.out.println("\n\n*******clearZeroToIthBit " + i + "th bit of " + number);
        String binaryString = Integer.toBinaryString(number);
        // System.out.println("Binary representation of number " + number + " is " + binaryString);
        int mask = (-1 << (i + 1));
        System.out.println("Mask binary = " + Integer.toBinaryString(mask));
        int response = number & mask;
        System.out.println("Number " + number + "(" + Integer.toBinaryString(number) + ") Clearing clearZeroToIthBit " + i + "th bit = " + response + "(" + Integer.toBinaryString(response) + ")");
        return response;
    }

    private static int updateBit(int number, int i, int bit) {
        System.out.println("\n\n*******Update " + i + "th bit of " + number + " with " + bit);
        String binaryString = Integer.toBinaryString(number);
        // System.out.println("Binary representation of number " + number + " is " + binaryString);
        int mask = ~(1 << i);
        System.out.println("Mask binary = " + Integer.toBinaryString(mask));
        int response = number & mask | (bit << i);
        System.out.println("Number " + number + "(" + Integer.toBinaryString(number) + ") updateBit " + i + "th bit = " + response + "(" + Integer.toBinaryString(response) + ")");
        return response;
    }
}
