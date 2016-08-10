
public class CacheLogic {
	public static void main(String[] args) {
		for(int i=0; i<4; i++) {
			//Change client configs
			
		}
	}
	
	public void cacheLogic() {
		int cache_count=1;
		int num_clients=2;
		String cacheNamePrefix = "AOS_SAMPLE123_";
		int cacheNameSuffix = 1;
		int members = 33;
		String cacheName = cacheNamePrefix + cacheNameSuffix;
		
		if (cache_count == 1) {
			for (int i = 0; i < members; i++) {
				for (int j = 0; j < num_clients; j++) {
					System.err.println(" Running java command on cache : " + cacheName);
				}
			}
		} else {
			for (int i = 0; i < members; i++) {
				for (int j = 0; j < num_clients; j++) {
					cacheName = cacheNamePrefix + cacheNameSuffix;
					System.err.println("Running java command on cache : " + cacheName);
					cacheNameSuffix++;
					if(cacheNameSuffix > cache_count) {
						cacheNameSuffix = 1;
					}
				}
			}
		}
	}
}
