package exceptions;

import java.util.ArrayList;
import java.util.List;



public class Main {
	public static void main(String[] args) {
//		int a = 32 % 0;
//		System.out.println(a);
		
		String[] mountInfoArray;
		List<String> weightedList = new ArrayList<String>();
		mountInfoArray = weightedList.toArray(new String[weightedList.size()]);
		System.out.println(mountInfoArray.length);
		
		int[] a = new int[0];
		System.out.println(a);
	}
}
