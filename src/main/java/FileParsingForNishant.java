import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class FileParsingForNishant {
	
	static String tableName="GNV_ASSET_12312_";

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
          int lastStripe=-1;
          SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
          
          String lastDate = null;
          HashMap<Integer,String> stripeDates = new HashMap<Integer,String>();
          while ((line = br.readLine()) != null) {
        	 
       		  String lastDateOfEachStripe=line.substring(line.indexOf(tableName) + length,line.indexOf(" UPDATE"));
       		  int stripe = Integer.parseInt(lastDateOfEachStripe.substring(0, lastDateOfEachStripe.indexOf("_")));
       		  String date = lastDateOfEachStripe.substring(lastDateOfEachStripe.indexOf("_")+1);
       		  if(lastStripe!=stripe && lastStripe!=-1)
       		  {
//       			System.out.println("Stripe : "+lastStripe+ "	Max Date :"+lastDate);
       			fileWriter.append("\n"+"Stripe : "+lastStripe+ "	Max Date :"+lastDate);
       			stripeDates.put(lastStripe, lastDate);
       		  }
       		  
       		  lastStripe=stripe;
       		  lastDate=date;
   		  }
//          System.out.println("Stripe : "+lastStripe+ "	Max Date :"+lastDate);
          fileWriter.append("\n"+"Stripe : "+lastStripe+ "	Max Date :"+lastDate);
          stripeDates.put(lastStripe, lastDate);
          
          Date finalMinDate=formatter.parse(stripeDates.get(0));
          
          for(int j=1; j<=stripeDates.size()-1;j++)
          {
        	  finalMinDate=(finalMinDate.compareTo(formatter.parse(stripeDates.get(j)))>0)?(formatter.parse(stripeDates.get(j))):finalMinDate;
        	          	  
          }
          System.out.println("Your minimum date is : "+finalMinDate);
		  fileWriter.append("\n"+"Your minimum date is : "+finalMinDate);          
          
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
