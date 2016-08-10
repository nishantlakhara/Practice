
public class InsertReadThroughCache {

		public static void main(String[] args) {
			StringBuilder sb = new StringBuilder();
			sb.append("exec STRMADMIN.GSD_STREAMS_ADM.SET_TAG(HEXTORAW('17'));");
			sb.append("\n");
			
			int[] topics = {12907 ,12906 ,12908 ,12910 ,12920 ,12917 ,12914 ,12923 ,12909 ,12919 ,12916 ,12913 ,12922 ,12911 ,12921 ,12918 ,12915 ,12924 ,12904 ,12903 ,12905};
			int id1 = 245;
			int id2 = 246;
			
			for(int i=0; i<topics.length; i++) {
				sb.append("insert into GNV_TOPIC_COLLECTIONS values (" + id1 + ", 'QA_global_bucket'," + topics[i] + " , 1, 1, '13-FEB-15 07.10.13.000000 AM' ,'CB' , 'T_K' , 1);");
				sb.append("\n");
				sb.append("insert into GNV_TOPIC_COLLECTIONS values (" + id2 + ", 'QA_global_bucket'," + topics[i] + " , 2, 2, '13-FEB-15 07.10.13.000000 AM' ,'CB' , 'T_K' , 1);");
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


