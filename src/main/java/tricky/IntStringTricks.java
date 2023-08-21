package tricky;

public class IntStringTricks {
    public static void main(String[] args) {
        intTricks();

        stringTricks();

        longTricks();

        unaryTricks();
    }

    private static void unaryTricks() {
        int i = 10;
        int j = i++ + i++;
        System.out.println("i++ + i++   , i == " + i + ", j == " + j);

        i = 10;
        j = i++ + i++ + i++;
        System.out.println("i++ + i++ + i++ i == " + i + ", j == " + j);

        i = 10;
        j = ++i + ++i + ++i;
        System.out.println("++i + ++i + ++i i == " + i + ", j == " + j);

        i = 10;
        j = ++i + i++;
        System.out.println("++i + i++; i == " + i + ", j == " + j);

        i = 10;
        j = i++ + ++i;
        System.out.println("i++ + ++i; i == " + i + ", j == " + j);

        i = 10;
        j = i++ + -i++;
        System.out.println("i++ + -i++; i == " + i + ", j == " + j);

        i = 10;
        j = i++ + -++i + -i++;
        System.out.println("i++ + -++i + -i++; i == " + i + ", j == " + j);



    }

    private static void longTricks() {
        System.out.println("Long tricks");
        System.out.println(Integer.MAX_VALUE);
//        long l = 12345678901;   // Comp[ile error as number is above in integer range.
        long l = 12345678901l;   // Fix for above.
//        System.out.println(l);
    }

    private static void stringTricks() {
        String String = "String";
        System.out.println(String);

        String s1 = new String("MeHu");
        String s2 = new String("MeHu");

        if(s1 == s2) {
            System.out.println("me Me hi hu");
        } else {
            System.out.println("uff me to me nhi. new ki wajah se.");
        }

        if(s1.equals(s2)) {
            System.out.println("Me me nhi par dikhte ek jaise he");
        }
    }

    private static void intTricks() {
        int i = 'd';
        System.out.println(i);

        char c = 97;
        System.out.println(c);

        int octal = 027;
        System.out.println(octal);

//        int octal1 = 028;  // Comp[ile erroir
//        System.out.println(octal1);

        byte b = 10;
        int ib = b;
        System.out.println(ib);

        // Compile error without typecasting
        byte b1 = (byte) ib;

        // byte b2 = b + b1;   // Lossy conversion compile error
        // System.out.println(b2);

        int $ = 10;
        System.out.println($);

        int $abc = 20;
        System.out.println($abc);

        // String is not a keyword. its a classname
        int String = 10;
        System.out.println(String);
    }
}
