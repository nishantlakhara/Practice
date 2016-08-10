package com.parsehtml.jsoup;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
	public static void main(String[] args) throws IOException {
		File input = new File("/Users/admin/Desktop/projectwork/AOS/update/abc.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		
//		System.out.println(doc);
		
		Elements elements_even = doc.getElementsByClass("even");
		Elements elements_odd = doc.getElementsByClass("odd");
		
		
//		System.out.println(elements_even);
		getCAIssues(elements_even, elements_odd);
		
	}
	
	public static void getCAIssues(Elements elements_even, Elements elements_odd) {
		int count =0;
		for(int i=0; i<elements_even.size(); i++) {
			Element element = elements_even.get(i);
			if(element.getElementsByAttribute("data-issue-id") != null) {
				Elements trElement = element.getElementsByClass("title");
				String status = element.getElementsByClass("status").html();
				if(trElement.html().contains("CA") && !status.equals("Resolved")) {
					System.out.println(trElement.html());
					System.out.println(element.getElementsByClass("notes"));
					count++;
				}
			}
		}
		
		for(int i=0; i<elements_odd.size(); i++) {
			Element element = elements_odd.get(i);
			if(element.getElementsByAttribute("data-issue-id") != null) {
				Elements trElement = element.getElementsByClass("title");
				String status = element.getElementsByClass("status").html();
				if(trElement.html().contains("CA") && !status.equals("Resolved")) {
					System.out.println(trElement.html());
					System.out.println(element.getElementsByClass("notes"));
					count++;
				}
			}
		}
		
		System.err.println("Count ===  " + count);
	}
	
	public static void getWWIssues(Elements elements_even, Elements elements_odd) {
		int count =0;
		for(int i=0; i<elements_even.size(); i++) {
			Element element = elements_even.get(i);
			if(element.getElementsByAttribute("data-issue-id") != null) {
				Elements trElement = element.getElementsByClass("title");
				String status = element.getElementsByClass("status").html();
				if(trElement.html().startsWith("WW") && !status.equals("Resolved")) {
					System.out.println(trElement.html());
					System.out.println(element.getElementsByClass("notes"));
					count++;
				}
			}
		}
		
		for(int i=0; i<elements_odd.size(); i++) {
			Element element = elements_odd.get(i);
			if(element.getElementsByAttribute("data-issue-id") != null) {
				Elements trElement = element.getElementsByClass("title");
				String status = element.getElementsByClass("status").html();
				if(trElement.html().startsWith("WW") && !status.equals("Resolved")) {
					System.out.println(trElement.html());
					System.out.println(element.getElementsByClass("notes"));
					count++;
				}
			}
		}
		
		System.err.println("Count ===  " + count);
	}
}
