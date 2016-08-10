
public class InsertMountPath {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("exec STRMADMIN.GSD_STREAMS_ADM.SET_TAG(HEXTORAW('17'));");
		sb.append("\n");
		
		int[] topics = {10502,10503,11376,11379,11380,11381,11392,11410,11412,11428,11437,11438,11396,11402,11404,11405,11407,11433,11434,11435,11378,11409,11411,11436,11440,11441,11443,10899,11391,11398,11399,11400,11416,11424,11425,11427,11426,11442,11395,11377,11397,11401,11403,11406,11408,11259,11382,11383,11393,11394,11417,11418,11419,11420,11422,11423,11421,11240,11241,11429,11430,11431,11432,11242};
		int id1 = 25;
		int id2 = 26;
		
		for(int i=0; i<topics.length; i++) {
			sb.append("INSERT INTO GNV_MOUNT (MOUNT_ID, MOUNT_PATH, MOUNT_CAPACITY, MOUNT_USAGE, MOUNT_WEIGHT, SITE_ID, TOPIC_ID) VALUES (" + id1 + ", '/ngs/app/genevad/poc/MDN_ncisi05_primary/QA', 1099511627776, 0, 0, 2, " + topics[i] + ");");
			sb.append("\n");
			sb.append("INSERT INTO GNV_MOUNT (MOUNT_ID, MOUNT_PATH, MOUNT_CAPACITY, MOUNT_USAGE, MOUNT_WEIGHT, SITE_ID, TOPIC_ID) VALUES (" + id1 + ", '/ngs/app/genevad/poc/MDN_ncisi03_primary/QA', 1099511627776, 0, 1, 1, " + topics[i] + ");");
			sb.append("\n");
			sb.append("INSERT INTO GNV_MOUNT (MOUNT_ID, MOUNT_PATH, MOUNT_CAPACITY, MOUNT_USAGE, MOUNT_WEIGHT, SITE_ID, TOPIC_ID) VALUES (" + id2 + ", '/ngs/app/genevad/poc/REN_ncisi06_primary/QA', 1099511627776, 0, 1, 2, " + topics[i] + ");");
			sb.append("\n");
			sb.append("INSERT INTO GNV_MOUNT (MOUNT_ID, MOUNT_PATH, MOUNT_CAPACITY, MOUNT_USAGE, MOUNT_WEIGHT, SITE_ID, TOPIC_ID) VALUES (" + id2 + ", '/ngs/app/genevad/poc/REN_ncisi04_primary/QA', 1099511627776, 0, 0, 1, " + topics[i] + ");");
			sb.append("\n");
			id1 += 2;
			id2 += 2;
		}
		
		sb.append("commit;");
		sb.append("\n");
		sb.append("exec STRMADMIN.GSD_STREAMS_ADM.SET_TAG(NULL);");
		
		System.out.println(sb.toString());
	}
}
