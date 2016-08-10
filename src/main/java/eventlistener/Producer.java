package eventlistener;

import java.util.ArrayList;

public class Producer {
	  // allow a third party to plug in a listener
	  
	  ArrayList<ProducerEventListener> my_listeners = new ArrayList<ProducerEventListener>();
	  FooEvent foo;
	  BarEvent bar;
	  int amount;
	  
	  public void setEventListener(ProducerEventListener a_listener) {
	    my_listeners.add(a_listener);
	  }

	  public void somethingHappened() {
	    for(int i=0;i<my_listeners.size();i++) {
	    	ProducerEventListener my_listener = my_listeners.get(i);
	    	if (my_listener != null) { 
	    		if(foo!=null) {
	    			my_listener.onFooHappened(foo);
	    		}
	    		if(bar!=null) {
	    			my_listener.onBarOccured(bar);
	    		}
	    		if(amount > 0) {
	    			System.out.println("This is the amount set : " + amount);
	    			my_listener.display(amount);
	    		}
	    	}
	    }
	  }

	public FooEvent getFoo() {
		return foo;
	}

	public void setFoo(FooEvent foo) {
		this.foo = foo;
	}

	public BarEvent getBar() {
		return bar;
	}

	public void setBar(BarEvent bar) {
		this.bar = bar;
	}
	
	public void setAmount(int i) {
		this.amount = i;
		somethingHappened();
	}
}
