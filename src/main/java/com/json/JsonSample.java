package com.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonSample {
	public static void main(String[] args) throws IOException, ParseException {
		
		File file = new File("/Users/admin/Desktop/Logs_ 16294169.txt");
		BufferedReader br = new BufferedReader(new FileReader("/Users/admin/Desktop/Logs_ 16294169.txt"));
		String json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		
		json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		json = br.readLine();
		parseJSON2(json);
    }
	
	public static void parseJSON1(String json) throws ParseException {
		List<String> lArr = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
        JSONObject jsonObject = (JSONObject)obj;
        JSONArray array = (JSONArray)jsonObject.get("files");
        int count =0 ;
        for(int i=0 ; i<array.size() ; i++) {
        	//System.out.println(((JSONObject)array.get(i)).get("id"));
        	lArr.add((String) ((JSONObject)array.get(i)).get("id"));
        	count++;
        }
        System.out.println("Count : " + count);
        
        for(int i=1 ; i<=1010; i++) {
        	if(!lArr.contains("key_" + i)) {
        		System.out.println("key_" + i);
        	}
        }
	}
	
	public static void parseJSON2(String json) throws ParseException {
		List<String> lArr = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
        JSONObject jsonObject = (JSONObject)obj;
        JSONArray array = (JSONArray)((JSONObject)((JSONArray)((JSONObject)((JSONArray)jsonObject.get("children")).get(0)).get("children")).get(0)).get("children");
        int count =0 ;
        for(int i=0 ; i<array.size() ; i++) {
        	//System.out.println(((JSONObject)array.get(i)).get("id"));
        	lArr.add((String) ((JSONObject)array.get(i)).get("id"));
        	count++;
        }
        System.out.println("Count : " + count);
        
        for(int i=0 ; i<1010; i++) {
        	if(!lArr.contains("Key_" + i)) {
        		System.out.println("Key_" + i);
        	}
        }
	}
	
	
}
