package design.connectionpool;

public class ConnectionPool implements ConnectionPoolInterface {
    int size;
    BlockingQueue<MyConnection> blockingQueue;

    public ConnectionPool(int size) throws InterruptedException {
        this.size = size;
        this.blockingQueue = new BlockingQueue<>(size);

        for(int i=0; i<size; i++) {
            blockingQueue.put(new MyConnection(this, "Connection-" + (i+1)));
        }
    }

    @Override
    public MyConnection getConnection() throws InterruptedException {
        //System.out.println("Waiting for connection");
        MyConnection myConnection = blockingQueue.take();
        System.out.println("Received connection " + myConnection);
        return myConnection;
    }


    @Override
    public void releaseConnection(MyConnection myConnection) throws InterruptedException {
        if(myConnection != null) {
            //System.out.println("============Releasing connection " + myConnection);
            blockingQueue.put(myConnection);
            System.out.println("============Connection Released " + myConnection) ;
        } else {
            //System.out.println("Cannot release connection. Connection is null.");
        }
    }
}
