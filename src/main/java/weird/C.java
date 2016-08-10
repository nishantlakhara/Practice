package weird;

class A {
	protected int a = 10;
//	protected void abc() {
//		System.out.println(this.getClass().getName());
//	}
}
 class B extends A {
	 B() {
		 a=20;
	  }
 }
 
 public class C extends B {
	 public static void main(String[] args) {
		 A c = new C();
		 System.out.println(c.a);
	}
 }