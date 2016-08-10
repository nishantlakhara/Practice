import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class SetUtilities {
	public static void main(String[] args) throws IOException {
//		BufferedReader br1 = new BufferedReader(new FileReader("ids/app_id_site_1.txt"));
//		BufferedReader br2 = new BufferedReader(new FileReader("ids/app_id_site_2.txt"));
//		BufferedReader br1 = new BufferedReader(new FileReader("ids/etsqa2_1_Site1.txt"));
//		BufferedReader br2 = new BufferedReader(new FileReader("ids/etsqa2_1_Site2.txt"));
//		BufferedReader br1 = new BufferedReader(new FileReader("ids/etsqa2_2_Site1.txt"));
//		BufferedReader br2 = new BufferedReader(new FileReader("ids/etsqa2_2_Site2.txt"));
//		compare2IntegerSets("ids/site1_ids.txt" , "ids/site2_ids.txt");
//		compare2StringSets("/Users/admin/Desktop/projectwork/QA/update/list7.txt" , "/Users/admin/Desktop/projectwork/QA/update/list8.txt");
//		readAfileAndRemoveDuplicates("/Users/admin/Desktop/projectwork/QA/update/list_topics.txt");
//		compare2StringSets("/Users/admin/Desktop/projectwork/QA/update/1.txt", "/Users/admin/Desktop/projectwork/QA/update/2.txt");
		readAFileAndCreateStringSet("/Users/admin/Desktop/projectwork/AOS/update/out.txt");
	}
	
	public static void iterateThroughIntegerSet(Set<String> set1) {
		Iterator<String> it = set1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public static Set<String> readAFileAndCreateStringSet(String path) throws NumberFormatException, IOException {
		Set<String> set = new HashSet<String>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String str;
		int totalElements = 0;
		while((str = br.readLine()) != null) {
			set.add(str);
			totalElements++;
		}
		br.close();
		System.out.println("Total elements in set: " + set.size());
		System.out.println("Total elements in file: " + totalElements);
		return set;
	}
	
	public static void compare2IntegerSets(String path1 , String path2) throws NumberFormatException, IOException {
//		BufferedReader br1 = new BufferedReader(new FileReader("ids/site1_ids.txt"));
//		BufferedReader br2 = new BufferedReader(new FileReader("ids/site2_ids.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader(path1));
		BufferedReader br2 = new BufferedReader(new FileReader(path2));
		
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		
		String str;
		
		while((str = br1.readLine()) != null) {
			set1.add(Integer.parseInt(str)); 
		}
		
		while((str = br2.readLine()) != null) {
			set2.add(Integer.parseInt(str)); 
		}
		
		br1.close();
		br2.close();
		//Intersection of two sets :
		Set<Integer> intersection = new HashSet<Integer>(set1);
		intersection.retainAll(set2);
		System.out.println("\n\nINTERSECTION : " + intersection.size());
		System.out.println(intersection);
		
		//Union of two sets :
		Set<Integer> union = new HashSet<Integer>(set1);
		union.addAll(set2);
		System.out.println("\n\nUNION : " + union.size());
		System.out.println(union);
		
		
		//Union - Intersection :
		Set<Integer> diff = new HashSet<Integer>(union);
		diff.removeAll(intersection);
		System.out.println("\n\nUNION - INTERSECTION : " + diff.size());
		System.out.println(diff);
		
		//On set 1 not on set 2
		Set<Integer> set1minus2 = new HashSet<Integer>(set1);
		set1minus2.removeAll(set2);
		System.out.println("\nOn set 1 not on set 2 : " + set1minus2.size());
		System.out.println(set1minus2);
		
		//On set 2 not on set 1
		Set<Integer> set2minus1 = new HashSet<Integer>(set2);
		set2minus1.removeAll(set1);
		System.out.println("\nOn set 1 not on set 2 : " + set2minus1.size());
		System.out.println(set2minus1);
	}
	
	public static void compare2StringSets(String path1 , String path2) throws NumberFormatException, IOException {
//		BufferedReader br1 = new BufferedReader(new FileReader("ids/site1_ids.txt"));
//		BufferedReader br2 = new BufferedReader(new FileReader("ids/site2_ids.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader(path1));
		BufferedReader br2 = new BufferedReader(new FileReader(path2));
		
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		
		String str;
		
		while((str = br1.readLine()) != null) {
			if(!set1.contains(str)) {
				set1.add(str);
			} else {
				String str1 = str + "$";
				while(true) {
					if(set1.contains(str) && set1.contains(str1)) {
						str1 = str1 + "$";
					} else {
						set1.add(str1);
						break;
					}
				}
			}
		}
		
		while((str = br2.readLine()) != null) {
			if(!set2.contains(str)) {
				set2.add(str.trim()); 
			} else {
				String str1 = str + "$";
				while(true) {
					if(set2.contains(str) && set2.contains(str1)) {
						str1 = str1 + "$";
					} else {
						set2.add(str1);
						break;
					}
				}
			}
		}
		
		System.out.println("SET 1 : " + set1);
		System.out.println(set1.size());
		System.out.println("SET 2 : " + set2);
		System.out.println(set2.size());
		
		//Intersection of two sets :
		Set<String> intersection = new HashSet<String>(set1);
		intersection.retainAll(set2);
		System.out.println("\n\nINTERSECTION : " + intersection.size());
		System.out.println(intersection);
		
		//Union of two sets :
		Set<String> union = new HashSet<String>(set1);
		union.addAll(set2);
		System.out.println("\n\nUNION : " + union.size());
		System.out.println(union);
		
		
		//Union - Intersection :
		Set<String> diff = new HashSet<String>(union);
		diff.removeAll(intersection);
		System.out.println("\n\nUNION - INTERSECTION : " + diff.size());
		System.out.println(diff);
		
		//On set 1 not on set 2
		Set<String> set1minus2 = new HashSet<String>(set1);
		set1minus2.removeAll(set2);
		System.out.println("\nOn set 1 not on set 2 : " + set1minus2.size());
		System.out.println(set1minus2);
		
		//On set 2 not on set 1
		Set<String> set2minus1 = new HashSet<String>(set2);
		set2minus1.removeAll(set1);
		System.out.println("\nOn set 2 not on set 1 : " + set2minus1.size());
		System.out.println(set2minus1);
	}
	
	public static void readAfileAndRemoveDuplicates(String path) throws IOException {
		BufferedReader br1 = new BufferedReader(new FileReader(path));
		Set<String> set1 = new HashSet<String>();
		
		String str;
		
		while((str = br1.readLine()) != null) {
			set1.add(str.trim()); 
		}
		
		System.out.println("SET 1 : " + set1);
		iterateThroughIntegerSet(set1);
		br1.close();
	}
}
