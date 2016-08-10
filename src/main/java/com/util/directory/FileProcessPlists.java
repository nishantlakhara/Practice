package com.util.directory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileProcessPlists {
	public static void main(String[] args) {
		List<String> list1 = IterateDirectories.iterateThroughDirectories("/Users/admin/Documents/workspace_UNICRON/Overrides/boostrap", true);
		List<String> list2 = IterateDirectories.iterateThroughDirectories("/Users/admin/Documents/workspace_UNICRON/Overrides/ncfiles", true);
		
		//Maps
		Map<String, List<String>> map1 = parseList(list1);
		Map<String, List<String>> map2 = parseList(list2);
		
		System.out.println(map1);
		System.out.println(map2);
		
		for (Map.Entry<String, List<String>> entry : map2.entrySet()) {
		    String key = entry.getKey();
		    List<String> value = entry.getValue();
		    if(map1.get(key) == null) {
		    	System.err.println(key + " not present");
		    } else {
		    	Set<String> set2 = new HashSet<String>(entry.getValue());
		    	Set<String> set1 = new HashSet<String>(map1.get(key));
		    	
		    	Set<String> set2minus1 = new HashSet<String>(set2);
				set2minus1.removeAll(set1);
				System.out.println("\nOn set 1 not on set 2 in " + key + " : " + set2minus1.size());
				System.out.println(set2minus1);
		    }
		}
		
		
//		//Compare two sets
//		Set<Integer> set2minus1 = new HashSet<Integer>(set2);
//		set2minus1.removeAll(set1);
//		System.out.println("\nOn set 1 not on set 2 : " + set2minus1.size());
//		System.out.println(set2minus1);
		
		//Compare two sets
		Set<String> set1 = new HashSet<String>(list1);
		Set<String> set2 = new HashSet<String>(list2);
		
		//Iterate through both sets
	}

	private static Map<String, List<String>> parseList(List<String> in) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Iterator<String> iter = in.iterator();
		while(iter.hasNext()) {
			String directory = iter.next();
			List<String> list = IterateDirectories.iterateThroughFiles(directory, false);
			List<String> listNamespaces = convertListToNamespaces(list);
			String split[] = directory.split("\\/");
			map.put(split[split.length - 1], listNamespaces);
		}
		return map;
	}

	private static List<String> convertListToNamespaces(List<String> list) {
		List<String> newList = new ArrayList<String>();
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()) {
			String val = iter.next();
			newList.add(val.split("\\.")[0]);
		}
		return newList;
	}
}
