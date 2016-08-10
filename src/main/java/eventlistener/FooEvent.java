package eventlistener;

public class FooEvent {
	public int foo;
	public void eventSummary() {
		System.out.println("Foo info  : " + foo);
	}
	public int getFoo() {
		return foo;
	}
	public void setFoo(int foo) {
		this.foo = foo;
	}
}
