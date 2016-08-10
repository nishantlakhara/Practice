import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


public class PropertiesLoader {
	public static void main(String[] args) {
		loadProperties("props/etsqa2_1.properties" , "ids/etsqa2_1_ids.txt");
	}
	
	public static void loadProperties(String inputPath , String outputPath) {
		Properties prop = new Properties();
		InputStream input = null;
		PrintWriter out = null;
		Set<String> set = new HashSet<String>();
		
		try {
	 
			input = new FileInputStream(inputPath);
	        out = new PrintWriter(outputPath);
			
			// load a properties file
			prop.load(input);
	 
			Iterator<Object> it = prop.keySet().iterator();
			while(it.hasNext()) {
				String str= prop.getProperty((String) it.next());
				out.println(str);
				set.add(str);
			}
			System.out.println(surroundWithQuotes(set));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null) {
				out.close();
			}
		}
	}

	private static String surroundWithQuotes(Set<String> set) {
		StringBuilder  sb = new StringBuilder("(");
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String str = it.next();
			sb.append("'");
			sb.append(str);
			sb.append("'");
			sb.append(",");
		}
		sb.append(")");
		return sb.toString();
	}
}
