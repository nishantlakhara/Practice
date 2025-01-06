package leetcode.bitwise;

public class BinaryToStringBetweenZeroToOne {
    public static void main(String[] args) {
        System.out.println(printBinaryApp1(0.875));
        System.out.println(printBinaryApp2(0.875));

        System.out.println(printBinaryApp1(0.625));
        System.out.println(printBinaryApp2(0.625));

        System.out.println(printBinaryApp1(0.125));
        System.out.println(printBinaryApp2(0.125));
    }

    public static String printBinaryApp1(double num) {
        System.out.println("===========================");
        if(num >= 1 || num <= 0) {
            return "ERROR";
        }
        System.out.println("num = " + num);

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num > 0) {
            if(binary.length() >= 32) {
                return "ERROR";
            }

            double r = num*2;
            System.out.println("r = " + r);
            if(r >= 1) {
                binary.append(1);
                num = r-1;
                System.out.println("num = " + num);
            } else {
                binary.append(0);
                num = r;
                System.out.println("num = " + num);
            }
        }
        return binary.toString();
    }

    public static String printBinaryApp2(double num) {
        System.out.println("===========================");
        if(num >= 1 || num <= 0) {
            return "ERROR";
        }
        System.out.println("num = " + num);

        StringBuilder binary = new StringBuilder();
        double frac = 0.5;
        binary.append(".");
        while(num > 0) {
            if(binary.length() >= 32) {
                return "ERROR";
            }

            if(num >= frac) {
                binary.append(1);
                num -= frac;
                System.out.println("num = " + num);
            } else {
                binary.append(0);
                System.out.println("num = " + num);
            }
            frac /= 2;
        }
        return binary.toString();
    }
}
