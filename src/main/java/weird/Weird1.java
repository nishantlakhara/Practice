package weird;

public class Weird1 {
    public static void main(String[] args) {
        stringTest1();
        stringTest2();
    }

    private static void stringTest2() {
        System.out.println("stringTest2");
        String s1 = "a";
        String s2 = "a";
        String s3 = new String(s1);

        System.out.println("s1 == s2" + s1 == s2);
        System.out.println("s2 == s3" + s2 == s3);
        System.out.println("s1 == s3" + s1 == s3);
    }

    private static void stringTest1() {
        System.out.println("stringTest1");
        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");

        System.out.println("s1 == s2" + s1 == s2);
        System.out.println("s2 == s3" + s2 == s3);
        System.out.println("s1 == s3" + s1 == s3);
    }
}



