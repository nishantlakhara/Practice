package strings;

import java.util.Arrays;
import java.util.Locale;

public class StringUtilitiesMain {
    public static void main(String[] args) {
        String str = new String("abcdabcdefghijklmnopqrst ab.cd.ef     uvw  xyz abcdefgh");
        str.toCharArray();
        System.out.println(str.startsWith("abc"));
        System.out.println(str.toLowerCase(Locale.ROOT));
        System.out.println(str.toLowerCase());
        System.out.println(str.getBytes());
        System.out.println(str.toUpperCase(Locale.ROOT));
        System.out.println(str.toUpperCase());
        System.out.println(str.length());
        System.out.println(str.contains("def"));
        System.out.println(str.trim());
        Arrays.stream(str.split(" ")).forEach(System.out::println);
        Arrays.stream(str.split("\\s+")).forEach(System.out::println);
        System.out.println(str.replace("defgh", "DEFGH"));
        System.out.println(str.replaceAll("abcd", "haha"));
        Arrays.stream(str.split("\\.")).forEach(System.out::println);
        Arrays.stream(str.split(".")).forEach(System.out::println);
        System.out.println(str.charAt(0));
        System.out.println(str.substring(4));
        System.out.println(str.substring(4,8));
        System.out.println(str.indexOf('d'));
        System.out.println(str.codePointAt(4));
        System.out.println(str.concat("haha"));
        System.out.println(str.isEmpty());
        System.out.println(str.lastIndexOf('d'));
        System.out.println(str.lastIndexOf("abcd"));
        System.out.println(str.lastIndexOf('d', 20));
        System.out.println(str.lastIndexOf("abcd", 3));
        System.out.println(str.matches("abcd.*"));
    }
}
