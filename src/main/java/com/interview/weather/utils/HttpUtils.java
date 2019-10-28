package com.interview.weather.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtils {
	
	private static Logger log = Logger.getLogger(HttpUtils.class);

	public static JSONObject getConnetion(String url) throws Exception {
		JSONObject resp = null;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			
			try {
				resp = new JSONObject(response.toString());
			} catch (JSONException e) {
				log.error("Exception on calling weather api",e);
				throw new Exception(e);
			}
			
		} else {
			System.out.println("GET request not worked");
		}
		return resp;

	}
	
	
}
