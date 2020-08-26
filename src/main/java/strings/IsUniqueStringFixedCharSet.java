package strings;

/** Cracking the coding interview - Chapter 01 - Arrays and strings **/
/* Assumes only letters a through z. */
public class IsUniqueStringFixedCharSet {

    /* Assumes only letters a through z. */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        System.out.println("|checker|" + "val|" + "1<<val|");
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
//            System.out.println("|" + Integer.toBinaryString(checker) + "|" +
//                            Integer.toBinaryString(val) +  "|" +
//                            Integer.toBinaryString(1 << val) + "|");
            checker |= (1 << val);
        }
        //System.out.println("checker = " + Integer.toBinaryString(checker));
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }

//        char mychar = 'a';
//        for(int i=0; i<26; i++) {
//            int val = mychar - 'a';
//            System.out.println(mychar + " | " + Integer.toBinaryString(val) + " | " + Integer.toBinaryString(1 << val) );
//            System.out.println(mychar + " | " + val + " | " + (1 << val) );
//            mychar++;
    }
}
