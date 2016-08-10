package httpmethods;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class HTTPMethodsTest {
	
	
	
	public static void main(String[] args) {
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1, 
//				HttpStatus.SC_OK, "OK");
		
		
	}
	
	public static void putRequest() {
		URL url = null;
		try {
		   url = new URL("http://localhost:8080/P1");
		} catch (MalformedURLException exception) {
		    exception.printStackTrace();
		}
		HttpURLConnection httpURLConnection = null;
		DataOutputStream dataOutputStream = null;
		try {
		    httpURLConnection = (HttpURLConnection) url.openConnection();
		    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    httpURLConnection.setRequestMethod("PUT");
		    httpURLConnection.setDoInput(true);
		    httpURLConnection.setDoOutput(true);
		    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
		    dataOutputStream.writeChars("hello");
		} catch (IOException exception) {
		    exception.printStackTrace();
		}  finally {
		    if (dataOutputStream != null) {
		        try {
		            dataOutputStream.flush();
		            dataOutputStream.close();
		        } catch (IOException exception) {
		            exception.printStackTrace();
		        }
		    }
		    if (httpURLConnection != null) {
		        httpURLConnection.disconnect();
		    }
		}
	}
	
	public static void deleteRequest() {
		URL url = null;
		try {
		    url = new URL("http://localhost:8080/P1");
		} catch (MalformedURLException exception) {
		    exception.printStackTrace();
		}
		HttpURLConnection httpURLConnection = null;
		try {
		    httpURLConnection = (HttpURLConnection) url.openConnection();
		    httpURLConnection.setRequestProperty("Content-Type",
		                "application/x-www-form-urlencoded");
		    httpURLConnection.setRequestMethod("DELETE");
		    System.out.println(httpURLConnection.getResponseCode());
		} catch (IOException exception) {
		    exception.printStackTrace();
		} finally {         
		    if (httpURLConnection != null) {
		        httpURLConnection.disconnect();
		    }
		} 
	}
	
	public static void getReplicationDataRequest() {
		URL url = null;
		try {
		   url = new URL("http://url:8580/GenevaServers/GetReplicationData/geneva.all.asset.genevaserver");
		} catch (MalformedURLException exception) {
		    exception.printStackTrace();
		}
		HttpURLConnection httpURLConnection = null;
		DataOutputStream dataOutputStream = null;
		try {
		    httpURLConnection = (HttpURLConnection) url.openConnection();
		    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    httpURLConnection.setRequestMethod("PUT");
//		    httpURLConnection.setDoInput(true);
//		    httpURLConnection.setDoOutput(true);
//		    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
//		    dataOutputStream.writeChars("hello");
		} catch (IOException exception) {
		    exception.printStackTrace();
		}  finally {
		    if (dataOutputStream != null) {
		        try {
		            dataOutputStream.flush();
		            dataOutputStream.close();
		        } catch (IOException exception) {
		            exception.printStackTrace();
		        }
		    }
		    if (httpURLConnection != null) {
		        httpURLConnection.disconnect();
		    }
		}
	}
}
