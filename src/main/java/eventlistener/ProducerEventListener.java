package eventlistener;

public interface ProducerEventListener {
	void onFooHappened(FooEvent e);
	void onBarOccured(BarEvent e);
	void display(int amount);
}
