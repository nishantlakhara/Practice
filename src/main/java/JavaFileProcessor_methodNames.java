import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class JavaFileProcessor_methodNames {
	
		public static void main(String[] args) throws IOException {
			
			
			//PrintWriter pw = new PrintWriter(new File("/Users/admin/Desktop/3.txt"));
			//pw.println(sb);
			//pw.close();
			
			String filepath = "/Users/admin/Documents/workspace_Nishant_dev/GenevaTest-JBoss/src/com/abcd/ist/ets/geneva/hierarchicalasset/gn/unit/VirusScan.java";
			printMethodNames(filepath);
		}
		
		public static void printMethodNames(String filePath) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
			while((str = br.readLine())!=null) {
				
				if(str.contains("public void")) {
				    sb.append(str.trim().split("\\(")[0] + "()");
					sb.append("\n");
				}
						
			}
			
			System.out.println(sb);
			br.close();
		}
	}

