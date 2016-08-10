package com.jsonparse;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
	public static void main(String[] args) {
		jsonParse("/Users/admin/Desktop/projectwork/AOS/update/abc.json");
	}
	
	public static void jsonParse(String filePath) {
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(
            		filePath));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            JSONArray results = (JSONArray) ((JSONObject)jsonObject.get("msg")).get("results");
            for(int i=0; i<results.size(); i++) {
            	JSONArray files = (JSONArray) ((JSONObject)results.get(i)).get("files");
            	System.out.println(files.size());
            }
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
