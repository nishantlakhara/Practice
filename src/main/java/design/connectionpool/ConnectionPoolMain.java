package design.connectionpool;

public class ConnectionPoolMain {
    public static void main(String[] args) throws InterruptedException {
        final ConnectionPool connectionPool = new ConnectionPool(5);

        Runnable runnable1 = () -> {
            MyConnection connection = null;
            while(true) {
                try {
                    connection = connectionPool.getConnection();
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            connectionPool.releaseConnection(connection);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        int size = 10;
        Thread[] t = new Thread[size];
        for(int i=0; i<size; i++) {
            t[i] = new Thread(runnable1);
            t[i].start();
        }

        for(int i=0; i<size; i++) {
            t[i].join();
        }
    }
}
