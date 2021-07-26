package weird;

public class Weird2 {
    public static void main(String[] args) {

    }
}

class Parent {
    static void go() {
        System.out.println("Heyy");
    }
}

class Child extends Parent {
//    void go() {
//        System.out.println("Heyy");
//    }

    //Compile time error.
}
