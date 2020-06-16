package design.connectionpool;

import java.io.Closeable;
import java.io.IOException;

public class MyConnection implements Closeable {
    ConnectionPool connectionPool;
    String connectionName;

    public MyConnection(ConnectionPool connectionPool, String connectionName) {
        this.connectionPool = connectionPool;
        this.connectionName = connectionName;
    }

    @Override
    public String toString() {
        return "MyConnection{" +
                "connectionPool=" + connectionPool +
                ", connectionName='" + connectionName + '\'' +
                '}';
    }

    @Override
    public void close() throws IOException {
        try {
            connectionPool.releaseConnection(this);
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }
}
