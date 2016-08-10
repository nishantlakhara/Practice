import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class JavaFileProcess {
	public static void main(String[] args) throws IOException {
		 parseFile();
	}
	
	private static void parseFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/admin/Documents/workspace_UNICRON/Overrides/all_namespaces"));
		String str = null;
		StringBuilder sb = new StringBuilder();
		Map<String , List<String>> map = new HashMap<String, List<String>>();
		
		while((str = br.readLine()) != null) {
			if(str.contains("./")) {
//				System.out.println("Print folder :  " + str);
				String key = str.replace("./", "").replace("/", "").trim();
//				System.out.println("Print folder updated:  " + str);
				if(!map.containsKey(key)) {
					List<String> listNamespaces = new ArrayList<String>();
					map.put(key, listNamespaces);
				}
				
				try {
				while(!(str = br.readLine()).equals("")) {
					if(!map.get(key).contains(str.trim()))
						map.get(key).add(str.trim());
				}
				} catch (Exception e) {
					System.out.println("Hello");
				}
			}
		}
		
//		for (Entry<String, List<String>> entry : map.entrySet())
//		{
//		    System.out.println(entry.getKey());
//		    List<String> values = entry.getValue();
//		    Iterator<String> iter = values.iterator();
//		    while(iter.hasNext()) {
//		    	System.out.println("\t" + iter.next());
//		    }
//		}
		
		
		BufferedReader br1 = new BufferedReader(new FileReader("/Users/admin/Documents/workspace_UNICRON/Overrides/namespaces.txt"));
		String str1 = null;
		
		List<String> list = new ArrayList<String>(); 
		while((str1 = br1.readLine()) != null) {
			list.add(str1.trim());
		}
		
		Map<String, Set<String>> set = new HashMap<String, Set<String>>();
		List<String> list1 = new ArrayList<String>();
		for (Entry<String, List<String>> entry : map.entrySet())
		{
			String key = entry.getKey();
		    System.out.println(key);
		    List<String> values = entry.getValue();
		    List<String> newValues = new ArrayList<String>();
		    
		    Iterator<String> iter = values.iterator();
		    while(iter.hasNext()) {
//		    	System.out.println("\t" + iter.next());
		    	String name = iter.next();
		    	if(list.contains(name)) {
		    		newValues.add(name);
		    	}
		    }
		    
		    Iterator<String> iter1 = newValues.iterator();
		    while(iter1.hasNext()) {
		    	String str2 = iter1.next();
		    	System.out.println("\t" + str2);
		    	if(!set.containsKey(str2)) {
		    		Set<String> setString = new HashSet<String>();
		    		setString.add(key);
		    		set.put(str2, setString);
		    	}
		    	set.get(str2).add(key);
//		    	if(list1.contains(str2)) {
//		    		set.put(str2, set.get(str2).);
//		    	} else {
//		    		set.put(str2, key);
//		    	}
//		    	list1.add(str2);
		    }
		}
		
		
		System.out.println("***************Set********************");
		int count = 0;
		for (Entry<String, Set<String>> entry : set.entrySet())
		{	
			if(entry.getValue().size() > 1)
				System.out.println(entry.getKey() + "\t\t" + entry.getValue());
			count += entry.getValue().size();
			
		}
		
		System.out.println("Count*********  =     " + count);
		br.close();
		br1.close();
		
		
		
		
	}
}
