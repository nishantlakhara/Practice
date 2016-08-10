import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Reads {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		while((str = br.readLine()) != null) {
		str = str.trim();
		
		String s1= str.substring(0,str.indexOf(' ')).trim(); // "72"
		String s2= str.substring(str.indexOf(' ')+1).trim(); // "tocirah sneab"
		
		if(s2.equals("NOT NULL NUMBER")) {
			s2="NUMBER NOT NULL ENABLE";
		} else if(s2.startsWith("NOT NULL"))  {
			String s[] = s2.split("NOT NULL"); 
			//System.out.println(s[0]);
			//System.out.println(s[1]);
			s2=s[1] + " NOT NULL ENABLE";
		}
		
		//System.out.println("s1 = " + s1 );
		System.out.println("\"" + s1 + "\"" + " " +  s2 + ",");
		}
	}
}
