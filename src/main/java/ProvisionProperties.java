import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProvisionProperties {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/admin/Desktop/projectwork/AOS/update/queues.txt"));
        
        StringBuilder sb = new StringBuilder();
        String str;
   /*     
        "queueDestination1" = {
            queueQuota = 10000;
            attractedTopics = "topicByteProducerDestDiff1,topicByteProducerDestDiff";
            maxMsgSize = 10000000;
            maxMsgRedelivery = 3;
            respectMsgTTL = true;
            permission = 4;
            accessType = 1;
            discardbehaviour = 2;
            vpn = "DEV-VPN";
        };
   */     
        while((str = br.readLine()) != null) {
            sb.append("\"" + str + "\"" + " = {\n" );
            sb.append("\tqueueQuota = 10000;\n");
            sb.append("\tattractedTopics = \"\";\n");
            sb.append("\tmaxMsgRedelivery = 4;\n");
            sb.append("\tmaxMsgSize = 10000000;\n");
            sb.append("\trespectMsgTTL = true;\n");
            sb.append("\tpermission = 4;\n");
            sb.append("\taccessType = 1;\n");
            sb.append("\tdiscardbehaviour = 2;\n");
            sb.append("\tvpn = \"DEV-VPN\";\n");
            sb.append("};\n");
        }
        
        System.err.println(sb.toString());
        br.close();
    }
}
