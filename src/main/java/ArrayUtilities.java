import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ArrayUtilities {
	public static void main(String[] args) throws IOException {
		List<String>[] list = init();
		
		List<String> array1 = list[0];
		List<String> array2 = list[1];
		
		System.err.println(array1.size());
		System.err.println(array2.size());
		List<String> array3 = new ArrayList<String>(); 
		
		for(int i=0; i< array2.size(); i++) {
//			System.err.println(array2.get(i));
//			System.err.println(array1.contains(array2.get(i)));
			if(array1.contains(array2.get(i))) {
				array3.add(array2.get(i));
			}
		}
		
		for(int i=0; i< array3.size(); i++) {
			System.out.println(array3.get(i));
		}
		
		if(array3.size() != array1.size()) {
			for(int i=0; i< array1.size(); i++) {
				if(!array3.contains(array1.get(i))) {
					System.err.println(array1.get(i));
				}
			}
		}
	}
	
	public static List<String>[] init() throws IOException {
		String path1 = "1.txt";
		String path2 = "2.txt";
		
		BufferedReader br1 = new BufferedReader(new FileReader(path1));
		BufferedReader br2 = new BufferedReader(new FileReader(path2));
		
		List<String> array1 = new ArrayList<String>();
		List<String> array2 = new ArrayList<String>();
		
		String str;
		
		while((str = br1.readLine()) != null) {
			if(!array1.contains(str)) {
				array1.add(str.trim());
			}
		}
		
		while((str = br2.readLine()) != null) {
			if(!array2.contains(str)) {
				array2.add(str.trim()); 
			}
		}
	
		List<String> list[] = new List[] {array1, array2};
		return list;
		
	}
}
