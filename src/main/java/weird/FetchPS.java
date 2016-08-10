package weird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FetchPS {
	static {
//		String[] command = new String[] { "/bin/bash", "-c", "/bin/ps auxww|grep abcd"};
//		//System.setProperty("a","abcd");
//		Process p=null;
//		try {
//			p = Runtime.getRuntime().exec(command);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//	    StringBuilder out = new StringBuilder();
//	    String line;
//	    try {
//			while ((line = reader.readLine()) != null) {
//			    out.append(line);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    System.out.println(out.toString());   //Prints the string content read from input stream
//	    try {
//			reader.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    try {
//			Thread.sleep(300000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public FetchPS() {
		String[] command = new String[] { "/bin/bash", "-c", "/bin/ps auxww|grep abcd"};
		//System.setProperty("a","abcd");
		Process p=null;
		try {
			p = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	    StringBuilder out = new StringBuilder();
	    String line;
	    try {
			while ((line = reader.readLine()) != null) {
			    out.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(out.toString());   //Prints the string content read from input stream
	    try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new FetchPS();
//		String[] command = new String[] { "/bin/bash", "-c", "/bin/ps auxww|grep abcd"};
//		//System.setProperty("a","abcd");
//		Process p = Runtime.getRuntime().exec(command);
//		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//	    StringBuilder out = new StringBuilder();
//	    String line;
//	    while ((line = reader.readLine()) != null) {
//	        out.append(line);
//	    }
//	    System.out.println(out.toString());   //Prints the string content read from input stream
//	    reader.close();
//	    Thread.sleep(300000);
	}
}
