package com.parsehtml.jsoup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parse {
	public static void main(String[] args) throws IOException  {
		File input = new File("/Users/admin/Desktop/projectwork/AOS/update/def.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://url/");
		
		System.out.println("Elements");
//		System.out.println(doc);
		Elements elements = doc.select("a[href]");
		Iterator<Element> iter = elements.iterator();
		List<String> urlsList = new ArrayList<String>();
		int count = 0;
		while(iter.hasNext()) {
			String url = iter.next().attr("href");
			try {
			urlsList.add(url);
			
			//Skip AMR links
			count++;
//			if(url.contains("/mx/") || url.contains("/ca/") || url.contains("/br/") || url.contains("/xf/") || count <=15*25-3/*Skip first 14 urls us*/) {
////				System.err.println("Skipping : " + url);
//				continue;
//			}
			
//			//System.out.println("URL : " + url);
//			if(count % 15 == 12)
//				System.out.println("New");
//			if(url.contains("/jp/")) {
			Document docLocal = Jsoup.connect(url).timeout(30*1000).followRedirects(true).get();
			Elements elems = docLocal.select("img[alt]");
			Iterator<Element> iterelems = elems.iterator();
			while (iterelems.hasNext()) {
				Element element = (Element) iterelems.next();
				if(element.attr("alt").contains("We'll be back soon")) {
					System.out.println(url);
				}
			}
//				}
			} catch(Exception e) {
				System.out.println("FAILED : " + url + "\tReason : " + e.getLocalizedMessage());
			}
		}
	}
}
