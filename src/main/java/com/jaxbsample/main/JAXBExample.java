package com.jaxbsample.main;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import com.jaxbsample.PersonInfoType;

public class JAXBExample {
	public static void main(String[] args) {
	      //Create a PersonInfoType object
		  PersonInfoType person = new PersonInfoType();

	      //fill details of the PersonInfoType
		  person.setFirstname("Nishant");
		  person.setLastname("Lakhara");
	     

	      try {
	         //create JAXBElement of type PersonInfoType
	         //Pass it the PersonInfoType object
	         JAXBElement<PersonInfoType> jaxbElement =  new JAXBElement( 
	            new QName(PersonInfoType.class.getSimpleName()), PersonInfoType.class, person);

	         //Create a String writer object which will be 
	         //used to write jaxbElment XML to string
	         StringWriter writer = new StringWriter();

	         // create JAXBContext which will be used to update writer 		
	         JAXBContext context = JAXBContext.newInstance(PersonInfoType.class);

	         // marshall or convert jaxbElement containing PersonInfoType to xml format
	         context.createMarshaller().marshal(jaxbElement, writer);
	      
	         //print XML string representation of PersonInfoType object			
	         System.out.println( writer.toString() ); 

	      } catch (JAXBException e) {			
	         e.printStackTrace();
	      }
	   }
}


