package leetcode.bitwise;


/**
 * Leetcode 67. Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;
        while(i >= 0 || j >= 0) {
            // Get char from a
            if(i >= 0)
                carry += a.charAt(i--) - '0';

            if(j >= 0)
                carry += b.charAt(j--) - '0';

            // (1+1=2) -> 0, (1+0) -> 1, (0+0)=0
            sb.insert(0, carry % 2);

            // 2->1, 1->0, 0->0
            carry = carry/2;
        }

        if(carry == 1)
            sb.insert(0, carry);

        return sb.toString();
    }
}
