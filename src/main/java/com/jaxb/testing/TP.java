package com.jaxb.testing;

import java.io.File;
import java.io.IOException;

public class TP {
	public static void main(String[] args) throws IOException {
		String absoluteXmlFilePath = "config_11111/testcases/HAAPI/HA_None_Client_Compress.xml";
		int lastIndex = absoluteXmlFilePath.lastIndexOf("/");
		System.out.println("lastIndex" + lastIndex);
		System.out.println(absoluteXmlFilePath.substring(0,lastIndex));
		System.out.println(absoluteXmlFilePath);
		File dir = new File(absoluteXmlFilePath.substring(0,lastIndex));
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		File file = new File(absoluteXmlFilePath);
		if(!file.exists()) {
			file.createNewFile();
		}
		
//		if(tcst  != null) {
//			m.marshal(tcst, new File(absoluteXmlFilePath));
//		} else if (tct != null) {
//			m.marshal(tcst, new File(absoluteXmlFilePath));
//		}
	}
}
