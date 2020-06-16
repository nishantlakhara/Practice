package design.connectionpool;

public interface ConnectionPoolInterface {
    MyConnection getConnection() throws InterruptedException;
    void releaseConnection(MyConnection myConnection) throws InterruptedException;
}


