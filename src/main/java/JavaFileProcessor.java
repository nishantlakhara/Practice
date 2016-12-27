import java.io.BufferedReader;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class JavaFileProcessor {
	
	public static void main(String[] args) throws IOException {

		
		String filePath = "/Users/admin/Documents/Geneva_Phase2_1_NewAPIcopy/src/com/abcd/ist/abc.java";
		String outputPath = "/Users/admin/Documents/CacheTests.java";

		parseFileLowerCase();

	}
	
	private static void parseFileLowerCase() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringBuilder sb = new StringBuilder();
		Map<String , String> map = new HashMap<String, String>();
		
		while((str = br.readLine()) != null) {
			String s = str.replace("null;", "").replace("public static final String", "").trim().replace("=","").toLowerCase().trim();
			s= "\"" + s + "\"";
			String s1 = str.replace("null" , s);
			System.out.println(s1);
		}
		br.close();
		System.out.println(sb.toString());
	}

	private static void parseFileReplaceConstantsWithValues(String filePath , String outputPath) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringBuilder sb = new StringBuilder();
		Map<String , String> map = new HashMap<String, String>();
		
		while(!(str = br.readLine()).equals("end")) {
			map.put(str.trim(), str.trim().replaceAll("(?<=[a-z])([A-Z])", " $1").replace(" ", "_").toUpperCase().replace("\"", ""));
			//sb.append(str.replaceAll("(?<=[a-z])([A-Z])", " $1").replace(" ", "_").toUpperCase().replace("\"", ""));
		}
		br.close();
		
		
		Iterator<String> it = map.keySet().iterator();
		boolean flag = true;
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			if(flag == true) 
				br = new BufferedReader(new FileReader(filePath));
			else
				br = new BufferedReader(new FileReader(outputPath));
			flag= false;
			sb = new StringBuilder();
			while((str = br.readLine())!=null) {
				System.out.println("Str : " + str);
				System.out.println(key);
				System.out.println(value);
				str = str.replace(key, value);
				System.out.println("Str After : " + str);
				
				sb.append(str);
				sb.append("\n");
			}
			br.close();
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
		}
		System.out.println(sb.toString());
	}
	
	

	private static void parseFileCreateConstants() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringBuilder sb = new StringBuilder();
		
		while(!(str = br.readLine()).equals("end")) {
			//String split[] = str.split(regex);
			sb.append("String ");
			sb.append(str.replaceAll("(?<=[a-z])([A-Z])", " $1").replace(" ", "_").toUpperCase().replace("\"", ""));
			sb.append("=");
			sb.append(str.trim());
			sb.append(";\n");
			//System.out.println(str.replaceAll("(?<=[a-z])([A-Z])", " $1").replace(" ", "_").toUpperCase().replace("\"", ""));
		}

			System.out.println(sb);
			br.close();
	}
	
	

	private static void parseFileRemoveAsserts(String filePath,
			String outputPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String str = null;
		StringBuilder sb = new StringBuilder();
		
		while((str = br.readLine())!=null) {
			if(!str.contains("assert")) {
				sb.append(str);
				sb.append("\n");
			}
		}
//		<javac srcdir="${src.dir}" destdir="${build.dir}" classpathref="classpath">
//	    <include name="src/path/to/MyClass.java"/>
//	    <include name="src/path/to/AnotherClass.java"/>
//	</javac>
			
			System.out.println(sb);
			br.close();
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	}

	private static void parseFileNameGetFiles(String projectPath , String filePath, String outputPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String str = null;
		StringBuilder sb = new StringBuilder();
		
		while((str = br.readLine())!=null) {
			sb.append("<javac  srcdir=\"src/");
			sb.append(str);
			sb.append("\" destdir=\"${build}\" classpathref=\"classpath\" debug=\"true\" >");
			sb.append("\n");
			//System.err.println(projectPath + "/" +  str);
			File dir = new File(projectPath + "/src/" +  str);
			  File[] directoryListing = dir.listFiles();
			  if (directoryListing != null) {
				
			    for (File child : directoryListing) {
			    
			      if(child.getAbsolutePath().contains("java")) {
			    	  sb.append("<include name=\"");
			    	  sb.append("src/" + str + child.getName());
			    	  sb.append("\"/>");
			    	  sb.append("\n");
			      }
			    }
			  }
			 
			sb.append("</javac>");
			sb.append("\n");
		}
//		<javac srcdir="${src.dir}" destdir="${build.dir}" classpathref="classpath">
//	    <include name="src/path/to/MyClass.java"/>
//	    <include name="src/path/to/AnotherClass.java"/>
//	</javac>
			
			System.out.println(sb);
			br.close();
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	}

	private static void parseFileNamesReplaceJavaC(String filePath,
			String outputPath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String str = null;
		StringBuilder sb = new StringBuilder();
		
//		while((str = br.readLine())!=null) {
//			sb.append("<javac srcdir=\"src\\");
//			sb.append(str);
//			sb.append("\" destdir=\"${build}\" classpathref=\"classpath\" debug=\"true\" />"); 
//			sb.append("\n");
//		}
		
		while((str = br.readLine())!=null) {
		sb.append("/Users/admin/Documents/Geneva_Phase2_1_NewAPI/src/");
		sb.append(str);
		
		sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
		
		PrintWriter pw = new PrintWriter(new File(outputPath));
		pw.println(sb);
		pw.close();
	}

	public static void parseFile() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringBuilder sb = new StringBuilder();
		
		while(!((str = br.readLine())).equals("%%%")) {
			sb.append(str);
			sb.append("\n");
			if(str.contains(".putStream") || str.contains("putMultipartData") || str.contains("putBytes2")
					) {
				sb.append("\t\tpeek(fs, 1, key, bucketId, PUT,  true, true);");
				sb.append("\n");
			}
			if(str.contains(".delete")) {
				sb.append("\t\tpeek(fs, 1, key,bucketId, DELETE,  true, true);");
				sb.append("\n");
			}
			if(str.contains(".copyFile")) {
				//String str1 = str.split(",")[1]; 
				sb.append("\t\tpeek(fs, 1, newFileKey,newBucketId, COPY,  true, true);");
				sb.append("\n");
			}
			if(str.contains(".moveFile")) {
				String str1 = str.split(",")[1]; 
				sb.append("\t\tpeek(fs, 1, " + str1 + ",bucketId, MOVE,  true, false);");
				sb.append("\n");
			}
			if(str.contains(".putBytes")) {
				String str1 = str.split(",")[1]; 
				sb.append("\t\tpeek(fs, 1, " + str1 + ", bucketId, PUT,  true, true);");
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		
		PrintWriter pw = new PrintWriter(new File("/Users/admin/Desktop/3.txt"));
		pw.println(sb);
		pw.close();
	}
	
	public static void parseFileAsyncHA(String filepath , String outputPath) throws IOException {
		    
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
			while((str = br.readLine())!=null) {
				sb.append(str);
				sb.append("\n");
				if(str.contains(".putStream") 
						|| str.contains("putMultipartData") 
						|| str.contains("putBytes2") 
						||  str.contains("putStream(") 
						|| str.contains("putChunked(")
						) {
					sb.append("\t\tpeek(fs, 1, key, bucketId, PUT,  true, true);");
					sb.append("\n");
				}
				if(str.contains(".delete") || str.contains("remove")) {
					sb.append("\t\tpeek(fs, 1, key,bucketId, DELETE,  true, true);");
					sb.append("\n");
				}
				if(str.contains(".copyFile")) {
					//String str1 = str.split(",")[1]; 
					sb.append("\t\tpeek(fs, 1, newFileKey,newBucketId, COPY,  true, true);");
					sb.append("\n");
				}
				if(str.contains(".moveFile")) {
					String str1 = str.split(",")[1]; 
					sb.append("\t\tpeek(fs, 1, " + str1 + ",bucketId, MOVE,  true, false);");
					sb.append("\n");
				}
				if(str.contains("putBytes") && !(str.contains("public void"))) {
					String str1 = str.split(",")[1]; 
					sb.append("\t\tpeek(fs, 1," + str1 + ", bucketId, PUT,  true, true);");
					sb.append("\n");
				}
				if(str.contains("checkScanStatus")) {
					String str1 = str.split(",")[3].split("\\.")[2].split("\\)")[0];
					sb.append("\t\tpeek(fs, 1, key, SCAN, VirusScanStatus." + str1 + ",true, true, true);");
					sb.append("\n");
				}
				
				
			}
			
			System.out.println(sb);
			br.close();
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
		}
	
	    public static void parseFileToken(String filepath , String outputPath) throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader(filepath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
		
			while((str = br.readLine())!=null) {
				if(str.contains("%")) {
				Pattern p = Pattern.compile("%([^%]*)%");
				Matcher m = p.matcher(str);
				while (m.find()) {
					sb.append(m.group(1) + "\n");
					//System.out.println(m.group(1).replace("utility","console"));
				}
				}
			}
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	    }
	    
	    public static void parseFilePrependUrl(String filePath , String outputPath , String urlPath) throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader(filePath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
		
			while((str = br.readLine())!=null) {
				if(str.startsWith("http")) {
					sb.append(str + "\n");
				} else
					sb.append(urlPath + "/" + str + "\n");
			}
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	    	
	    }
	    
	    public static void parseFilePrependUrl1(String filePath , String outputPath , String urlPath) throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader(filePath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
		
			while((str = br.readLine())!=null) {
				if(str.startsWith("http:")) {
					str = str.replace("curtin","ma1-genevad-console");
					str=str.replace("http", "https");
					str =str.replace(":8580", "");
					sb.append(str + "\n");
				} else {
					str=urlPath + "/" + str;
					str = str.replace("curtin","ma1-genevad-console");
					str =str.replace("http", "https");
					str =str.replace(":8580", "");
					sb.append(str + "\n");
				}
				
			}
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	    	
	    }
	    
	    public static void parseFileAppendLine(String filePath , String outputPath ) throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader(filePath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
			while((str = br.readLine())!=null) {
				sb.append(str + "\n");
				if(str.contains("prepareStatement")) {
					String str1 = br.readLine();
					if(!str1.contains("setQueryTimeout")) {
						System.out.println(str.split("=")[0].trim());
						sb.append("\t\t\t" + str.split("=")[0].trim() + ".setQueryTimeout(Settings.getIntProperty(GenevaConstants.UTILITIES_QUERY_TIMEOUT, GenevaConstants.UTILITIES_QUERY_TIMEOUT_VALUE));" + "\n");
					} 
					sb.append(str1 + "\n");
				}
			}
			br.close();
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	    }
	    
	    public static void parseFile123(String filePath , String outputPath ) throws IOException {
	    	BufferedReader br = new BufferedReader(new FileReader(filePath));
			String str = null;
			StringBuilder sb = new StringBuilder();
			
			while((str = br.readLine())!=null) {
				if(str.contains("String")) {
					System.out.println("System.out.println(HierarchicalAssetDBQueryConstants." + str.split(" ")[1].trim() + ");");
				}
			}
			br.close();
			
			PrintWriter pw = new PrintWriter(new File(outputPath));
			pw.println(sb);
			pw.close();
	    }
	    
	    public static void parseInputHeadings() throws IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = null;
			
			int i=1;
			while((str = br.readLine())!=null) {
				if(str.contains(""+i)) {
					System.out.println(str);
					i++;
				}
			}
			br.close();
			
	    }
	    
	    
}
