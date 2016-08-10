package eventlistener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EventListenerExample {
	public static void main(String[] args) throws InterruptedException {
		Producer someProducer = new Producer();
		//someProducer.setEventListener(new Consumer());
		someProducer.setEventListener(new ProducerEventListener(){
			  public void onFooHappened(FooEvent e) {
			    if(e!=null) {
			    	System.out.println("Foo Event");
			    	e.eventSummary();
			    }
			  }    
			  public void onBarOccured(BarEvent e) {
				if(e!=null)  {
					System.out.println("Bar Event");
					e.eventSummary();
				}
			  }
			@Override
			public void display(int amount) {
				System.out.println("Amount # " + amount);
				
			} 
			});
		
		someProducer.setEventListener(new ProducerEventListener(){
			  int i=0;
			  public void onFooHappened(FooEvent e) {
			    if(e!=null) {
			    	System.out.println("Foo Event 1");
			    	e.eventSummary();
			    }
			  }    
			  public void onBarOccured(BarEvent e) {
				if(e!=null)  {
					System.out.println("Bar Event 1");
					e.eventSummary();
				}
			  }
			  @Override
			  public void display(int amount) {
				System.out.println("Amount : " + amount);
				i=amount;
			  } 
			});
		
		Thread t = listen(someProducer);
		//someProducer.setAmount(1000);
		//someProducer.somethingHappened();
		t.join();
	}

	private static Thread listen(final Producer someProducer) {
		
		Thread t = new Thread() {
			public void run() {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				for(int i=0;i<3;i++) {
					try {
						int k = Integer.parseInt(br.readLine());
						someProducer.setAmount(k);
					} catch (NumberFormatException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
			}
		};
		t.start();
		return t;
	}
}
