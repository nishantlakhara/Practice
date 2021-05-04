public class Parent {
    void method1() {
        System.out.println("parent");
    }

    public static void main(String[] args) {
        Parent p = new GrandChild();
        p.method1();
        //p.method2();
    }
}

class Child extends Parent {
    void method1() {
        System.out.println("child method 1");
    }
    void method2() {
        System.out.println("child method 2");
    }
}

class GrandChild extends Child {
    void method2() {
        System.out.println("grandchild method 2");
    }
}
