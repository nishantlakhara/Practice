package leetcode;

public class IntegerOverflow {
    public static void main(String[] args) {
        System.out.println(reverse(100000));
        System.out.println(reverse(Integer.MAX_VALUE));

        System.out.println((int)('2' - 48));
    }

    public static int reverseSlow(int x) {
        return Integer.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString());
    }

    public static int reverse(int x) {
        int result = 0, prev;
        while (x != 0) {
            prev = result;
            result *= 10;
            if (result / 10 != prev) {
                return 0;
            }
            result += x % 10;
            x /= 10;
        }
        return result;
    }
}
