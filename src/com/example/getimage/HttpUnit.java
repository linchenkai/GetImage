package com.example.getimage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUnit {
	public static InputStream getInputStreamFromURL(String imageURL){
		InputStream in = null;
		try{
			URL url = new URL(imageURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(5000);
			in = conn.getInputStream();
		}catch(Exception e){
			e.printStackTrace();
		}
		return in;
	}
}