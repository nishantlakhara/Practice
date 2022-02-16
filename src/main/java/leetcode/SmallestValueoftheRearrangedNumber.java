package leetcode;


/**
 * You are given an integer num. Rearrange the digits of num such that its value is minimized and it does not contain any leading zeros.
 *
 * Return the rearranged number with minimal value.
 *
 * Note that the sign of the number does not change after rearranging the digits.
 */
public class SmallestValueoftheRearrangedNumber {

    public static void main(String[] args) {
        System.out.println(smallestNumber(310));
        System.out.println(smallestNumber(-310));
    }

    //310
    public static long smallestNumber(long num) {
        long n = Math.abs(num);
        int[] digits = new int[10];

        //Count no of digits and put in array or map.
        while (n != 0) {
            digits[(int) (n % 10)] += 1;
            n /= 10;
        }


        long res = (num < 0) ? 0 : getFirst(digits);
        int inc = (num < 0) ? -1 : 1;
        int start = (num < 0) ? digits.length - 1 : 0;

        for (int i = start; i >= 0 && i < digits.length; i += inc) {
            while (digits[i]-- > 0) {
                res *= 10;
                res += i;
            }
        }

        res *= (num < 0) ? -1 : 1;

        return res;
    }

    private static int getFirst(int[] d) {
        for (int i = 1; i < d.length; i++) {
            if (d[i] > 0) {
                d[i]--;

                return i;
            }
        }

        return 0;
    }
}
