package trick;

public class B extends A{
    private void show(){System.out.println("B");}
    public static void main(){
        A a = new A();
        B b = new B();
        A ab = new B();

// Uncomment below to see.
//        a.show();
//        b.show();
//        ab.show();
    }
}