import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class FileParsing {
	
	static String tableName="GNV_ASSET_12209_";

     public static void main(String[] args) {

      System.out.println("Started writing");
	  writeToFile("MinimumDatesOfEachStripeIndex");
	  System.out.println("Completed writing");
}

  public static void writeToFile(String fileName) {
       
      FileWriter fileWriter = null;
      try {

    	  fileWriter = new FileWriter(fileName);

          //Write a new student object list to the CSV file
          BufferedReader br = new BufferedReader(new FileReader("FileWithAlterCommands"));
          String line;
          int length = tableName.length();
          HashMap stripeDates = new HashMap<>();
          String[] eachStripeDates = null;
          int initialStripe=-1;
          int i=0;
          SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
          Calendar cal = Calendar.getInstance();
          String currrentdate=formatter.format(cal.getTime());
          Date overallMinDateOfEachStripe=formatter.parse(currrentdate);
          while ((line = br.readLine()) != null) {
        	 
        	  if(line.contains("ALTER TABLE "))
       		  {
        		  String dateWithStripe=line.substring(line.indexOf(tableName) + length,line.indexOf(" UPDATE"));
//        		  System.out.println(dateWithStripe);
        		  int stripe = Integer.parseInt(dateWithStripe.substring(0, dateWithStripe.indexOf("_")));
        		  String date = dateWithStripe.substring(dateWithStripe.indexOf("_")+1);
        		  if(initialStripe!=stripe)
        		  {
        			  i=0;
        			  
        			  if(eachStripeDates!=null)
        			  {
        				  Date minDateOfEachStripe=formatter.parse(currrentdate);
        				  stripeDates.put(initialStripe, eachStripeDates);
        				  for(int j=0; j<eachStripeDates.length; j++)
        				  {
        					  if(eachStripeDates[j]!=null)
        					  {
//        						  System.out.println(eachStripeDates[j]);
	        						  if(minDateOfEachStripe.compareTo(formatter.parse(eachStripeDates[j]))>0)
	        						  {
	        							  minDateOfEachStripe=formatter.parse(eachStripeDates[j]);
	        						  }
        					  }
        					  
        				  }
        				  if(overallMinDateOfEachStripe.compareTo(minDateOfEachStripe)>0)
						  {
        					  overallMinDateOfEachStripe=minDateOfEachStripe;
						  }
//        				  System.out.println("Minimum Date : "+minDateOfEachStripe);
        				  fileWriter.append("\n"+minDateOfEachStripe);
        				  
        			  }
        			  eachStripeDates = null;
        			  eachStripeDates = new String[10];

//        			  System.out.println("\n"+stripe);
        			  fileWriter.append("\n"+stripe);
        			  initialStripe=stripe;
        		  }
//        		  System.out.println(" Date : "+date);
//        		  fileWriter.append("\n		"+date);
        		  eachStripeDates[i++]= date;
       		  }
        	  
           }
          if(eachStripeDates!=null)
		  {
			  Date minDateOfEachStripe=formatter.parse(currrentdate);
			  stripeDates.put(initialStripe, eachStripeDates);
			  for(int j=0; j<eachStripeDates.length; j++)
			  {
				  if(eachStripeDates[j]!=null)
				  {
//					  System.out.println(eachStripeDates[j]);
						  if(minDateOfEachStripe.compareTo(formatter.parse(eachStripeDates[j]))>0)
						  {
							  minDateOfEachStripe=formatter.parse(eachStripeDates[j]);
						  }
				  }
				  
			  }
			  if(overallMinDateOfEachStripe.compareTo(minDateOfEachStripe)>0)
			  {
				  overallMinDateOfEachStripe=minDateOfEachStripe;
			  }
//			  System.out.println("Minimum Date : "+minDateOfEachStripe);
			  fileWriter.append("\n"+minDateOfEachStripe);
			  
		  }
          System.out.println("overall Minimum Date : "+overallMinDateOfEachStripe);
          fileWriter.append("\n Overall Minimum : "+overallMinDateOfEachStripe);
           br.close();
           

              System.out.println();
          System.out.println("File was created successfully !!!");

      } catch (Exception e) {
          System.out.println("Error in FileWriter !!!");
          e.printStackTrace();
      } finally {
          try {
              fileWriter.flush();
              fileWriter.close();

          } catch (IOException e) {
              System.out.println("Error while flushing/closing FileWriter !!!");
              e.printStackTrace();
          }

      }

  }

}
