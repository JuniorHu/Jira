package org.itehcs.report.commom;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

	// ÊäÈëÎªURL×Ö·û´®
	public String retrStr(String s) {

		String result = "";
		try {

			URL url = new URL(s);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);

			char[] buffer = new char[1024];
			InputStream in = (InputStream) connection.getInputStream();

			int bytesRead = 0;

			BufferedReader reader = null;
			reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
			while ((bytesRead = reader.read(buffer)) != -1) {

				String temp = new String(buffer, 0, bytesRead);
				temp = new String(buffer, 0, bytesRead);
				result = result + temp;

			}
		} catch (Exception exception) {

			exception.printStackTrace();
		}
		
		return result;
	}
}
