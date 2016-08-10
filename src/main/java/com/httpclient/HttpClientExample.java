package com.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

public class HttpClientExample {

	private final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		HttpClientExample http = new HttpClientExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();
	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "url";
		
		HttpHost host = new HttpHost("url", 443, "https");
		CredentialsProvider provider = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("nlakhara", "Nishant#54321");
		provider.setCredentials(AuthScope.ANY, credentials);
		
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
		HttpGet request = new HttpGet(url);

		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		request.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
		request.addHeader("Accept-Encoding", "gzip, deflate, sdch");
		
		HttpResponse response = client.execute(host, request);

		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + 
                       response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
                       new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());

	}

//	// HTTP POST request
//	private void sendPost() throws Exception {
//
//		String url = "https://url/wcResults.do";
//
//		HttpClient client = new DefaultHttpClient();
//		HttpPost post = new HttpPost(url);
//
//		// add header
//		post.setHeader("User-Agent", USER_AGENT);
//
//		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
//		urlParameters.add(new BasicNameValuePair("cn", ""));
//		urlParameters.add(new BasicNameValuePair("locale", ""));
//		urlParameters.add(new BasicNameValuePair("caller", ""));
//		urlParameters.add(new BasicNameValuePair("num", "12345"));
//
//		post.setEntity(new UrlEncodedFormEntity(urlParameters));
//
//		HttpResponse response = client.execute(post);
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + post.getEntity());
//		System.out.println("Response Code : " + 
//                                    response.getStatusLine().getStatusCode());
//
//		BufferedReader rd = new BufferedReader(
//                        new InputStreamReader(response.getEntity().getContent()));
//
//		StringBuffer result = new StringBuffer();
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//		}
//
//		System.out.println(result.toString());
//
//	}

}