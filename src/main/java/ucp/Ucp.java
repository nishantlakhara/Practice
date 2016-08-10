package ucp;

import java.sql.SQLException;

import oracle.ucp.UniversalConnectionPoolAdapter;
import oracle.ucp.UniversalConnectionPoolException;
import oracle.ucp.admin.UniversalConnectionPoolManager;
import oracle.ucp.admin.UniversalConnectionPoolManagerImpl;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class Ucp {
	public static void main(String[] args) throws UniversalConnectionPoolException, SQLException {
		UniversalConnectionPoolManager mgr = UniversalConnectionPoolManagerImpl. getUniversalConnectionPoolManager();

		PoolDataSource  pds = PoolDataSourceFactory.getPoolDataSource();
		pds.setConnectionPoolName("mgr_pool");
		pds.setConnectionFactoryClassName("oracle.jdbc.pool.OracleDataSource");
		pds.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
		pds.setUser("<user>");
		pds.setPassword("<password>");

		mgr.createConnectionPool((UniversalConnectionPoolAdapter)pds);
	}
}
	

