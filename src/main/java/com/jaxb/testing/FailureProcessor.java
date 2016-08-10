package com.jaxb.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.jaxb.scenario.ObjectFactory;
import com.jaxb.scenario.TestCaseType;
import com.jaxb.scenario.TestClassType;
import com.jaxb.scenario.TestClassesType;
import com.jaxb.scenario.TestMethodType;
import com.jaxb.testjunit.TestcaseType;
import com.jaxb.testjunit.TestsuiteType;
import com.jaxb.usecase.ScenarioType;
import com.jaxb.usecase.UseCaseType;
import com.jaxb.usecase.UseCasesType;

public class FailureProcessor {
	public static void main(String[] args) throws JAXBException, IOException {
		FailureProcessor fp = new FailureProcessor();
		
		//Get Failure Map
		String pathOfXML = "/Users/admin/Downloads/Test_Results-11/html/TEST-junit.xml";
		String pathOutputFailure = "xmls/TEST-junit_FAILED.xml";
		Map<String , Map<String , List<String>>> failureMap = fp.generateFailureMapAndDumpFailureFile(pathOfXML , pathOutputFailure);
		
		//Combine all Usecases file and store.
		String usecaseFilePath = "config/usecase";
		String commonuseCaseFilePath = "config/usecase/CommonUsecase.xml";
		UseCasesType ucsCommon = combineUsecasesToOne(usecaseFilePath , commonuseCaseFilePath);
		
		//Create scenarioToXML map
//		List<String> scenarioToXML = parseUseCase(ucsCommon , failureMap);
		
//		UseCasesType ucsFailure = parseUseCaseGetFailureUsecases(ucsCommon , failureMap);
		//printScenarioToXMLMap(scenarioToXMLMap);
//		printList(scenarioToXML);
		//Create an xml containing failure testcases.
		generateXMLs(failureMap , ucsCommon);
	}
	
	

//	private static UseCasesType ucParseUsecaseFile(UseCasesType ucsCommon,
//			Map<String, Map<String, List<String>>> failureMap) {
//		
//	}



//	private static UseCasesType parseUseCaseGetFailureUsecases(
//			UseCasesType ucsCommon,
//			Map<String, Map<String, List<String>>> failureMap) throws CloneNotSupportedException {
//		
//		UseCasesType ucFailure = new UseCasesType();
//		////
//		List<UseCaseType> ucs = ucsCommon.getUseCase();
//		Set<String> ucNames = failureMap.keySet();
//		Iterator<String> it = ucNames.iterator();
//		int i=0;
//		while(it.hasNext()) {
//			//Get usecase name from failure map.
//			String ucName = it.next();
//			
//			//Get UC type from usecase xml.
//			UseCaseType uc = getUseCaseTypeFromUseCases(ucs , ucName);
//			
//			//Iterate through usecase to fetch scenarios
//			if(uc != null) {
//				//Fetch scenarios corresponding to usecase in failure map.
//				Map<String , List<String>> scenarios = failureMap.get(ucName);
//				
//				//Add usecase to failure map
//				UseCaseType ucf = new UseCaseType();
//				
//				ucFailure.getUseCase().add(ucf);
//				
//				//Iterate through failed scenarios
//				Set<String> scenariosSet = scenarios.keySet();
//				Iterator<String> itsc = scenariosSet.iterator();
//				while(itsc.hasNext()) {
//					String scenarioName = itsc.next();
//					//String xmlpath = null;
//					ScenarioType scf = new ScenarioType();
//					if(scenarioName != null) {
//						scf = getScenarioFromUC(uc , scenarioName , scenarios);
//					} 
//				}
// 			} 
//		}
//	
//		return null;
//	}



	private static ScenarioType getScenarioFromUC(UseCaseType uc,
			String scenarioName, Map<String, List<String>> scenarios) {
		ScenarioType scf = new ScenarioType();
		List<ScenarioType> scenariosUC = uc.getScenario();
		Iterator<ScenarioType> it = scenariosUC.iterator();
		while(it.hasNext()) {
			ScenarioType scenario = it.next();
			if(scenario.getName().equals(scenarioName)) {
				
			}
		}
		return scf;
	}



	private static void printList(List<String> scenarioToXML) {
		System.out.println("scenarioToXML : ");
		for(int i=0 ; i<scenarioToXML.size() ; i++ ) {
			System.out.println(scenarioToXML.get(i));
		}
	}



	private static void printScenarioToXMLMap(
			Map<String, String> scenarioToXMLMap) {
		Set<String> keys = scenarioToXMLMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(key == scenarioToXMLMap.get(key))
				System.out.println(key + "=" + scenarioToXMLMap.get(key));
		}
	}



//	private static void generateXML(
//			Map<String, Map<String, List<String>>> failureMap,
//			List<String> scenarioToXML) throws JAXBException {
//		TestClassesType tcs = new TestClassesType();
//		Set<String> scNames = scenarioToXMLMap.keySet();
//		Iterator<String> it = scNames.iterator();
//		while(it.hasNext()) {
//			String scenarioName = it.next();
//			String xmlPath = scenarioToXMLMap.get(scenarioName);
//			TestClassType tc = getTestClass(scenarioName , xmlPath);
//			if(tc != null)
//				tcs.getTestClass().add(tc);
//		}
//		generateXML(tcs , outputFailureCasesPath);
//	}



	private static void generateXMLs(Map<String, Map<String, List<String>>> failureMap , UseCasesType ucsCommon) throws JAXBException, IOException {
		Set<String> ucNames = failureMap.keySet();
		Iterator<String> it = ucNames.iterator();
		while(it.hasNext()) {
			String ucName = it.next();
			UseCaseType uc = getUseCaseTypeFromUseCases(ucsCommon.getUseCase(), ucName);
			Map<String , String> scenarioToXMLMap = getScenarioToXML(uc , failureMap.get(ucName));
			Iterator<String> scit = scenarioToXMLMap.keySet().iterator();
			while(scit.hasNext()) {
				String scenario = scit.next();
				System.out.println(scenario);
				if(scenarioToXMLMap.get(scenario) != null)
					generateXML(scenario , scenarioToXMLMap.get(scenario) , failureMap.get(ucName).get(scenario));
			}
		}
		
//		JAXBContext context = JAXBContext.newInstance(TestClassesType.class);
//		Marshaller m = context.createMarshaller();
//		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//		m.marshal(failureMap , new File(ucsCommon));
	}



	private static void generateXML(String scenario, String xmlFilePath,
			List<String> failedTestcaseList) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller um = context.createUnmarshaller();
		System.out.println("XMLFILE ==  " + xmlFilePath);
	
		JAXBElement tcstJaxb = (JAXBElement) um.unmarshal(new FileReader(xmlFilePath));
		TestClassesType tcst = null;
		TestClassType tct = null;
		if(tcstJaxb.getValue() instanceof TestClassesType) {
			tcst = (TestClassesType)tcstJaxb.getValue();
			tct = tcst.getTestClass().get(0);
		} else if(tcstJaxb.getValue() instanceof TestClassType) {
			tct = (TestClassType)tcstJaxb.getValue();
		}
	
		int length = tct.getContent().size();
		int index=0;
		for(int i=0 ; i<length ; i++) {
			Object tmtJaxb = tct.getContent().get(index);
			JAXBElement jaxb = null;
			if(tmtJaxb instanceof JAXBElement)  {
				jaxb = (JAXBElement)tmtJaxb;
				
				System.out.println(tmtJaxb);
				TestMethodType tmt = (TestMethodType)jaxb.getValue();
				if(tmt != null) {
					System.err.println(tmt.getName());
					boolean exists = removeExtraTestCases(tmt , failedTestcaseList);
					if(exists == false) {
						tct.getContent().remove(index);
						index--;
					}
				}
				else 
					System.err.println("NOT TMT == " + jaxb.getValue().getClass());
			} else {
				System.err.println("NOT JAXB ELEMENT : " + tmtJaxb);
			}
			index++;
		}
		
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		String absoluteXmlFilePath = xmlFilePath.replace("config","config_fail");
		int lastIndex = absoluteXmlFilePath.lastIndexOf("/");
		File dir = new File(absoluteXmlFilePath.substring(0,lastIndex));
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		File file = new File(absoluteXmlFilePath);
		if(!file.exists()) {
			file.createNewFile();
		}
		
		if(tcst  != null) {
			m.marshal(tcst, new File(absoluteXmlFilePath));
		} else if (tct != null) {
			m.marshal(tct, new File(absoluteXmlFilePath));
		}
	}



	private static boolean removeExtraTestCases(TestMethodType tmt,
			List<String> failedTestcaseList) {
		boolean status = false;
		List<TestCaseType> testcases = tmt.getTestCase();
		int length = testcases.size();
		int index = 0 ;
		for(int i=0 ;i<length; i++) {
			TestCaseType tct = testcases.get(index);
			boolean exists = failedTestcaseList.contains(tct.getName());
			if(exists) {
				status = true;
				//Optimization possible : remove from failedTestcaseList
			} else {
				tmt.getTestCase().remove(index);
				index--;
			}
			index++;
		}
		return status;
	}



	private static Map<String, String> getScenarioToXML(UseCaseType uc,
			Map<String, List<String>> map) {
		Map<String, String> scenarioToXMLMap = new HashMap<String , String>();
		Iterator<String> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			String scf = iter.next();
			String xmlpath = getXMLPath(uc, scf);
			scenarioToXMLMap.put(scf , xmlpath);
			System.out.println(scf + "==" + xmlpath);
		}
		return scenarioToXMLMap;
	}



	private static TestClassType getTestClass(String scenarioName,
			String xmlPath) throws JAXBException {
		TestClassType tc = null;
		
		//Create unmarshaller
		JAXBContext context = JAXBContext.newInstance(TestClassesType.class);
		Unmarshaller um = context.createUnmarshaller();
		JAXBElement<TestClassesType> jaxbTcsScenario = (JAXBElement<TestClassesType>) um.unmarshal(new File(xmlPath));
		TestClassesType tcsScenario = jaxbTcsScenario.getValue();
		if(tcsScenario .getTestClass().size() > 0)
			tc = tcsScenario.getTestClass().get(0);
		else
			System.out.println("No Testclass in scenario : " + scenarioName);
		return tc;
	}



	private static List<String> parseUseCase(UseCasesType ucsCommon,
			Map<String, Map<String, List<String>>> failureMap) {
		List<String> scenarioToXML = new ArrayList<String>();
		List<UseCaseType> ucs = ucsCommon.getUseCase();
		Set<String> ucNames = failureMap.keySet();
		Iterator<String> it = ucNames.iterator();
		while(it.hasNext()) {
			//Get usecase name from failure map.
			String ucName = it.next();
			
			//Get UC type from usecase xml.
			UseCaseType uc = getUseCaseTypeFromUseCases(ucs , ucName);
			
			//Iterate through usecase to fetch scenarios
			if(uc != null) {
				//Fetch scenarios corresponding to usecase in failure map.
				Map<String , List<String>> scenarios = failureMap.get(ucName);
				
				//Iterate through failed scenarios
				Set<String> scenariosSet = scenarios.keySet();
				Iterator<String> itsc = scenariosSet.iterator();
				while(itsc.hasNext()) {
					String scenarioName = itsc.next();
					String xmlpath = null;
					if(scenarioName != null)
						xmlpath = getXMLPath(uc , scenarioName);
					if(xmlpath!=null) {
						scenarioToXML.add(uc.getName() + "@@" + scenarioName + "@@" + xmlpath);
					}
					else 
						System.err.println("SKIPPED Usecase : " + uc.getName() + "\t Scenario : " + scenarioName);
				}
 			}
		}
		return scenarioToXML;
	}

	private static String getXMLPath(UseCaseType uc, String scenarioName) {
		List<ScenarioType> scList = uc.getScenario();
		Iterator<ScenarioType> scit = scList.iterator();
		while(scit.hasNext()) {
			ScenarioType sc = scit.next();
			if(sc.getName().equals(scenarioName))
				return sc.getImport();
		}
		return null;
	}



	private static UseCaseType getUseCaseTypeFromUseCases(List<UseCaseType> ucs , String useCaseName) {
		Iterator<UseCaseType> it = ucs.iterator();
		while(it.hasNext()) {
			UseCaseType uc = it.next();
			if(uc.getName().equals(useCaseName)) 
				return uc;
		}
		return null;
	}

	private static UseCasesType combineUsecasesToOne(String usecaseFilePath,
			String commonuseCaseFilePath) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(UseCasesType.class);
		Unmarshaller um = context.createUnmarshaller();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		UseCasesType ucsCommon = new UseCasesType();
		List<UseCaseType> uctCommon = ucsCommon.getUseCase();
		File dir = new File(usecaseFilePath);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File file : directoryListing) {
		    	UseCasesType ucs = (UseCasesType) um.unmarshal(new FileReader(file.getAbsolutePath()));
		    	Iterator<UseCaseType> it = ucs.getUseCase().iterator();
		    	while(it.hasNext()) {
		    		UseCaseType uct = it.next();
		    		uctCommon.add(uct);
		    	}
		    }
		  } else {
		     System.out.println("No files exist");
		  }
//		// Write to System.out
//			m.marshal(ucsCommon, System.out);
			
		// Write to File
		   m.marshal(ucsCommon, new File(commonuseCaseFilePath));
		   
		return ucsCommon;
	}

	public Map<String , Map<String , List<String>>> generateFailureMapAndDumpFailureFile( String pathOfXML , String pathOutputFailure) throws FileNotFoundException, JAXBException {
		//String pathOfXML = "xmls/TEST-junit.xml";
		TestsuiteType ts = parseTestSuiteXML(pathOfXML);
		//String pathOutputFailure = "xmls/TEST-junit_FAILED.xml";
		writeToXML(ts , pathOutputFailure);
		Map<String , Map<String , List<String>>> failureMap = startParsingFailedCases(ts);
		System.out.println("FAILURE MAP == ");
		printResult(failureMap);
		return failureMap;
	}
	
	private void writeToXML(TestsuiteType ts,
		String writeTsToPath) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(TestsuiteType.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		
//		// Write to System.out
//		m.marshal(ts, System.out);
		
		// Write to File
		m.marshal(ts, new File(writeTsToPath));
	}
	
	public UseCasesType parseTestSuiteXMLUseCaseType(String path) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(UseCasesType.class);
		Unmarshaller um = context.createUnmarshaller();
		UseCasesType ts = (UseCasesType) um.unmarshal(new FileReader("/Users/admin/Documents/workspace_QA/Geneva_Phase2_1/config/usecase/AssetUC.xml"));
		
		return ts;
	}

	public TestsuiteType parseTestSuiteXML(String path) throws JAXBException, FileNotFoundException {
		JAXBContext context = JAXBContext.newInstance(TestsuiteType.class);
		Unmarshaller um = context.createUnmarshaller();
		JAXBElement<TestsuiteType> ts = (JAXBElement<TestsuiteType>)um.unmarshal(new FileReader(path));

		List<TestcaseType> tcs = ts.getValue().getTestcase();

		System.err.println(tcs.size());
		int i=0;
		while(i<tcs.size()) {
			TestcaseType tc = tcs.get(i);
			if(tc.getContent() != null && tc.getContent().size() == 0) {
				tcs.remove(i);				
			} else
				i++;
		}
		System.err.println(tcs.size());
		return ts.getValue();
	}
	
	public  Map<String , Map<String , List<String>>> startParsingFailedCases(TestsuiteType ts) {
		Map<String , Map<String , List<String>>> map = new LinkedHashMap<String , Map<String , List<String>>>();
		Iterator<TestcaseType> it = ts.getTestcase().iterator();
		while(it.hasNext()) {
			TestcaseType tc = it.next();
			String name = tc.getName();
	        String classname = tc.getClassname();
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
		return map;
	}
	
	private  void printResult(
			Map<String, Map<String, List<String>>> failureMap) {
		for(String uc : failureMap.keySet()) {
			System.out.println("USECASE : " + uc);
			Map<String, List<String>> scMap = failureMap.get(uc);
			printResult(scMap , "\t\t");
		}
	}
	
	private  void printResult(Map<String, List<String>> scMap,
			String padding) {
		for(String sc : scMap.keySet()) {
			System.out.println(padding +  "SCENARIO : " + sc);
			List<String> listTestcases = scMap.get(sc);
			printResult(listTestcases , "\t\t\t\t");
		}
	}
	
	private  void printResult(List<String> listTestcases, String padding) {
		Iterator<String> it = listTestcases.iterator();
		while(it.hasNext()) {
			String testcase = it.next();
			System.out.println(padding + testcase);
		}
	}
}

//ArrayList<Book> bookList = new ArrayList<Book>();
//
//// create books
//Book book1 = new Book();
//book1.setIsbn("978-0060554736");
//book1.setName("The Game");
//book1.setAuthor("Neil Strauss");
//book1.setPublisher("Harpercollins");
//bookList.add(book1);
//
//Book book2 = new Book();
//book2.setIsbn("978-3832180577");
//book2.setName("Feuchtgebiete");
//book2.setAuthor("Charlotte Roche");
//book2.setPublisher("Dumont Buchverlag");
//bookList.add(book2);
//
//// create bookstore, assigning book
//Bookstore bookstore = new Bookstore();
//bookstore.setName("Fraport Bookstore");
//bookstore.setLocation("Frankfurt Airport");
//bookstore.setBookList(bookList);
//
//// create JAXB context and instantiate marshaller
//JAXBContext context = JAXBContext.newInstance(Bookstore.class);
//Marshaller m = context.createMarshaller();
//m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//// Write to System.out
//m.marshal(bookstore, System.out);
//
//// Write to File
//m.marshal(bookstore, new File(BOOKSTORE_XML));
//
//// get variables from our xml file, created before
//System.out.println();
//System.out.println("Output from our XML File: ");
//Unmarshaller um = context.createUnmarshaller();
//Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));
//ArrayList<Book> list = bookstore2.getBooksList();
//for (Book book : list) {
//  System.out.println("Book: " + book.getName() + " from "
//      + book.getAuthor());
//}
//}
