package com.util.directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IterateDirectories {
	public static void main(String... args) {
		String filepath = "/Users/admin/Documents/workspace_UNICRON/Overrides/boostrap.desktop";
	    List<String> list = iterateThroughDirectories(filepath, true);
	    
	}

	public static void showFiles(File[] files) {
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            showFiles(file.listFiles()); // Calls same method again.
	        } else {
	            System.out.println("File: " + file.getName());
	        }
	    }
	}
	
	public static List<String> iterateThroughDirectories(String filepath, boolean absolute) {
		List<String> list = new ArrayList<String>();
		File[] files = new File(filepath).listFiles();
		for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            if(absolute)
	            	list.add(file.getAbsolutePath());
	            else {
	            	System.err.println(file.getName());
	            	list.add(file.getName());
	            }	
	        }
		}
		return list;
	}
	
	public static List<String> iterateThroughFiles(String filepath, boolean absolute) {
		List<String> list = new ArrayList<String>();
		File[] files = new File(filepath).listFiles();
		for (File file : files) {
	        if (!file.isDirectory()) {
	            System.out.println("File: " + file.getName());
	            if(absolute)
	            	list.add(file.getAbsolutePath());
	            else {
	            	list.add(file.getName());
	            }	
	        }
		}
		return list;
	}
}
