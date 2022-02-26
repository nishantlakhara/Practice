package wrapperclasses;

public class WrapperCheck {
    public static void main(String[] args) {
            Integer i  = 5;
            display(i);
            System.out.println(i);
    }

    private static void display(Integer i) {
        i = 10;
    }
}
