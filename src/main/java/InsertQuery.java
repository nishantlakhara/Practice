
public class InsertQuery {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("exec STRMADMIN.GSD_STREAMS_ADM.SET_TAG(HEXTORAW('17'));");
		sb.append("\n");
		
		int[] topics = {559,700,723,605,710,706,703,705,702,704,708,10461,12000,12276,12231,10369,10477,12267,10480,11376,11379,11380,12260,12266,12272,10481,12229,11437,11438,11960,12297,12300,11967,12234,11396,11405,12290,12295,12304,10631,12313,10627,12316,12033,12038,12056,12028,11400,11416,11425,12052,12164,12063,12035,12007,12062,11420,12216,12529,12531,12524,12537,12498,12597,12599,12602,12564,12568,12549,12557,12620,12626,12627,12616};
		System.out.println(topics.length);
		
		for(int i=0; i<topics.length; i++) {
			sb.append("update gnv_topic set topic_max_part=1, topic_version=topic_version+1 where topic_id=" + topics[i] + ";");
			sb.append("\n");
		}
		
		sb.append("commit;");
		sb.append("\n");
		sb.append("exec STRMADMIN.GSD_STREAMS_ADM.SET_TAG(NULL);");
		
		System.out.println(sb.toString());
	}
}
