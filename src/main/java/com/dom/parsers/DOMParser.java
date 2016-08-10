package com.dom.parsers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {
	private static int countTestcases;
	public static void main(String[] args) throws Exception{
		getFailureCases("/Users/admin/Library/Containers/com.boss.mail/Data/Library/Mail Downloads/4579BC48-E999-4D63-B79F-AB290BFEA30B/ColdOnlyReports/MULTI_FILE/reports/html/TEST-junit.xml");
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/none/AssetNCTagCrossDCTests.xml" , "testcases/testcases1.txt" , "testcases/outputXML1.xml" );
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/none/AssetNCRealTimeTagSearchTests.xml" , "testcases/testcases2.txt" , "testcases/outputXML2.xml" );
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/none/AssetNCRealTimeTagSearchCrossDCTests.xml" , "testcases/testcases3.txt" , "testcases/outputXML3.xml" );
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/eventual/AssetECTagTestsCrossDCTests.xml" , "testcases/testcases4.txt" , "testcases/outputXML4.xml" );
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/eventual/AssetECRealTimeTagSearchTests.xml" , "testcases/testcases5.txt" , "testcases/outputXML5.xml" );
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/eventual/AssetECRealTimeTagSearchCrossDCTests.xml" , "testcases/testcases6.txt" , "testcases/outputXML6.xml" );
//		generateXML("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/testcases/asset/tag/strong/AssetSCTagTests.xml" , "testcases/testcases7.txt" , "testcases/outputXML7.xml" );
		
//		generateXML("config/testcases/asset/none/AssetNCTests.xml" , "testcases1.txt" , "outputXML1.xml" );
//		generateXML("config/testcases/asset/eventual/AssetECTests.xml" , "testcases2.txt" , "outputXML2.xml" );
//		generateXML("config/testcases/asset/empty_payload/none/AssetNCEPTests.xml" , "testcases3.txt" , "outputXML3.xml" );
//		generateXML("config/testcases/asset/misc/none/AssetATSCacheDisabledRegionEnabled.xml" , "testcases4.txt" , "outputXML4.xml" );
//		generateXML("config/testcases/asset/misc/none/AssetATSCacheEnabledRegionDisabled.xml" , "testcases5.txt" , "outputXML5.xml" );
//		generateXML("config/testcases/asset/misc/none/AssetATSCacheEnabledRegionEnabled.xml" , "testcases6.txt" , "outputXML6.xml" );
//		generateXML("config/testcases/asset/strong/part/AssetSCSyncScanPartTests.xml" , "testcases7.txt" , "outputXML7.xml" );
		
		//Today : 
		//config/testcases/asset/virusscan/none/misc/AssetNCVirusScanAllAssetsAsyncMiscTests.xml
//		generateXML("config/testcases/asset/virusscan/none/misc/AssetNCVirusScanAllAssetsAsyncMiscTests.xml" , "testcases8.txt" , "outputXML8.xml" );
//		generateXML("config/testcases/asset/misc/none/AssetATSCacheDisabledRegionDisabled.xml" , "testcases9.txt" , "outputXML9.xml" );
		generateXML("/Users/admin/Library/Containers/com.boss.mail/Data/Library/Mail Downloads/4579BC48-E999-4D63-B79F-AB290BFEA30B/ColdOnlyReports/SINGLE_FILE/reports/html/TEST-junit.xml" , "testcases.txt" , "outputXML1.xml" );
	}
	
	public static void getFailureCases(String path) throws ParserConfigurationException, SAXException, IOException {
		//Set output
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("output1.txt")), true));
				System.setErr(new PrintStream(new BufferedOutputStream(new FileOutputStream("output_err1.txt")), true));
				
				//Create Document Builder
				DocumentBuilderFactory builderFactory =
				        DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = null;
				builder = builderFactory.newDocumentBuilder();
				
				
				//Create Document and start parsing.
					Document document = builder.parse(
				        new FileInputStream(path));
				    
				    Map<String , Map<String , List<String>>> failureMap = startParsingFailedCases(document);
				    printResult(failureMap);
				    System.out.println("No of testcases failures : " + countTestcases);
	}
	
	
	
	private static void printResult(
			Map<String, Map<String, List<String>>> failureMap) {
		for(String uc : failureMap.keySet()) {
			System.out.println("USECASE : " + uc);
			Map<String, List<String>> scMap = failureMap.get(uc);
			printResult(scMap , "\t\t");
		}
	}

	private static void printResult(Map<String, List<String>> scMap,
			String padding) {
		for(String sc : scMap.keySet()) {
			System.out.println(padding +  "SCENARIO : " + sc);
			List<String> listTestcases = scMap.get(sc);
			printResult(listTestcases , "\t\t\t\t");
		}
	}

	private static void printResult(List<String> listTestcases, String padding) {
		Iterator<String> it = listTestcases.iterator();
		while(it.hasNext()) {
			String testcase = it.next();
			System.out.println(padding + testcase);
		}
		countTestcases +=  listTestcases.size();
	}

	public static Map<String , Map<String , List<String>>> startParsingFailedCases(Document document) {
		Map<String , Map<String , List<String>>> map = new LinkedHashMap<String , Map<String , List<String>>>();
		Element rootElement = document.getDocumentElement();
	    NodeList nodes = rootElement.getChildNodes();
		for(int i=0; i<nodes.getLength(); i++){
		      Node node = nodes.item(i);

		      if(node instanceof Element){
		        //a child element to process
		        Element child = (Element) node;
		        String name = child.getAttribute("name");
		        String classname = child.getAttribute("classname");
		        Node firstChildOfChild = child.getFirstChild();
		        if(firstChildOfChild != null) {
		        	
		        	String[] split = classname.split("\\|");

		        	if(map.containsKey(split[0])) {
		        		Map<String , List<String>> scMap = map.get(split[0]);
		        		if(scMap.containsKey(split[1])) {
		        			List<String> listTestcases = scMap.get(split[1]);
		        			listTestcases.add(name);
		        		} else {
		        			List<String> listTestcases = new ArrayList<String>();
		        			listTestcases.add(name);
		        			scMap.put(split[1], listTestcases);
		        		}
		        	} else {
		        		Map<String , List<String>> scMap = new LinkedHashMap<String , List<String>>();
		        		List<String> listTestcases = new ArrayList<String>();
		        		listTestcases.add(name);
		        		scMap.put(split[1], listTestcases);
		        		map.put(split[0], scMap);
		        		
		        	}
		        }
		      }
		    }
		 return map;
	}
	
	
	
	public static void generateXML(String scenarioXMLPath , String testCasesNamesFilePath , String outputFilePath) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		ArrayList<String> testCasesNames = getListTestCasesFile(testCasesNamesFilePath);
		System.out.println(testCasesNames);
		//Create Document Builder
		DocumentBuilderFactory builderFactory =
		        DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		builder = builderFactory.newDocumentBuilder();
		
		
		//Create Document and start parsing.
			Document document = builder.parse(
		        new FileInputStream(scenarioXMLPath));
		
		startParsingFailedCases(document , testCasesNames);
		
		writeContentIntoXMLFile(document , outputFilePath);
	}
	
	private static void writeContentIntoXMLFile(Document document,
			String outputFilePath) throws TransformerException {
		// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(new File(outputFilePath));
		 
				// Output to console for testing
				// StreamResult result = new StreamResult(System.out);
		 
				transformer.transform(source, result);
		 
				System.out.println("File saved!");
	}

	private static ArrayList<String> getListTestCasesFile(
			String testCasesNamesFilePath) throws IOException {
		ArrayList<String> list  = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader( new File(testCasesNamesFilePath))) ;
		String line;
		while((line = br.readLine()) != null)
		{
		    System.out.println(line);
		    list.add(line);
		}
		return list;
	}

	public static void startParsingFailedCases(Document document ,  ArrayList<String> methodNames) throws ParserConfigurationException {
		
		Element rootElement = document.getDocumentElement();
		
		NodeList nodes = rootElement.getChildNodes();
		for(int i=0; i<nodes.getLength(); i++){
		      Node node = nodes.item(i);
		      
		      if(node instanceof Element){
		        //a child element to process
		        Element child = (Element) node;
		        System.out.println(child.getNodeName());
		        if(child.getNodeName().equals("test-class")) {
		        	processElementTestClass(child , methodNames);
		        }
		      }
		 }
	}

	private static void processElementTestClass(Element element , ArrayList<String> testCasesNames) {
		NodeList nodes = element.getChildNodes();
		for(int i=0; i<nodes.getLength(); i++){
		      Node node = nodes.item(i);
		      
		      if(node instanceof Element){
		        //a child element to process
		        Element child = (Element) node;
		        System.out.println(child.getNodeName());
		        if(child.getNodeName().equals("test-method")) {
		        	boolean methodRequired = processTestcases(child , testCasesNames);
		        	if(methodRequired == false) {
		        		element.removeChild(child);
		        	} 
		        }
		      }
		 }
	}

	private static boolean processTestcases(Element element , ArrayList<String> testCasesNames) {
		boolean required = false;
		NodeList nodes = element.getChildNodes();
		for(int i=0; i<nodes.getLength(); i++){
		      Node node = nodes.item(i);
		      
		      if(node instanceof Element){
		        //a child element to process
		        Element child = (Element) node;
		        System.out.println(child.getNodeName());
		        if(child.getNodeName().equals("test-case")) {
		        	boolean testCaseRequired = processTestcasesRequired(child , testCasesNames);
		        	if(testCaseRequired == false) {
		        		element.removeChild(child);
		        	} else {
		        		required = true;
		        	}
		        }
		      }
		 }
		return required;
	}

	private static boolean processTestcasesRequired(Element element,
			ArrayList<String> testCasesNames) {
		boolean exists = false;
		String testcaseName = element.getAttribute("name");
		
	
		for(int i=0; i<testCasesNames.size() ; i++) {
			String testCase = testCasesNames.get(i);
			if(testCase.equals(testcaseName)) {
				exists = true;
				testCasesNames.remove(i);
			} 
			
		}
		return exists;
	}
	
	
}
