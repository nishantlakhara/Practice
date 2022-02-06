package leetcode;

public class DivisionWithoutMultiplicationEtc {
    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MAX_VALUE));
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs(Integer.MIN_VALUE + 1));

        System.out.println(divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(divide(Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MIN_VALUE, 1));
        System.out.println(divide( 1, Integer.MIN_VALUE));
        System.out.println(divide( 1, Integer.MIN_VALUE));
        System.out.println(divide(Integer.MIN_VALUE, 3));
        System.out.println(divide(Integer.MIN_VALUE, -3));

        System.out.println("-------------------------------------");
        System.out.println(Integer.MIN_VALUE  - 3);
        System.out.println(Integer.MIN_VALUE  + 3);
        System.out.println(Integer.MIN_VALUE  - Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE  + Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE  - Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE  + Integer.MIN_VALUE);
        System.out.println("-------------------------------------");

        System.out.println("-------------------------------------");
        System.out.println(Integer.MAX_VALUE  - 3);
        System.out.println(Integer.MAX_VALUE  - 3);
        System.out.println("-------------------------------------");
    }

    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        boolean sign = dividend>0 ^ divisor>0;
        int q = 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend - divisor >= 0) {
            int temp = divisor;
            int c=0;
            while (dividend - temp >= 0) {
                temp = temp << 1;
                c++;
            }
            temp = divisor;
            dividend = dividend - (temp << c-1);
            q += 1 << c-1;
        }

        if(sign) return -q;
        return q;
    }
}
