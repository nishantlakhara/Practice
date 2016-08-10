package eventlistener;

class Consumer implements ProducerEventListener {
	  public void onFooHappened(FooEvent e) {
	    //log.info("Got " + e.getAmount() + " of foo");
	  }

	@Override
	public void onBarOccured(BarEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(int amount) {
		// TODO Auto-generated method stub
		
	}
	  
	}
