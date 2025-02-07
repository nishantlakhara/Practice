package leetcode.strings;

public class InsertAnywhereCreatePalindrome {

    /**
     * Insert anywhere to create a shortest palindrome
     * @param args
     */
    public static void main(String[] args) {
        String s = "abcbabcab";

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder(s);
        String sR = new StringBuilder(sb).reverse().toString();

        int i=0;
        int N=s.length();
        int k=N-1;
        int j=0;
        while(i < N) {
            if(i > k)
                break;
            if(s.charAt(i) == s.charAt(k)) {
                i++;
                k--;
            } else {
                sb.insert(i+j, s.charAt(k));
                k--;
                j++;
            }
        }

        System.out.println(sb.toString());
    }
}
