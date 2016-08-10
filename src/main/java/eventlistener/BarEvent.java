package eventlistener;

public class BarEvent {
	public int bar;
	public void eventSummary() {
		System.out.println("Bar info  : " + bar);
	}
	
	public int getBar() {
		return bar;
	}
	
	public void setBar(int bar) {
		this.bar = bar;
	}
}
