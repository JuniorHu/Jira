import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import sun.misc.BASE64Encoder;

public class JiraTest {

	private String url_pre = "https://jira.hpdd.intel.com/rest/";

	public JiraTest() {

	}

	public void connectJira() {

		//
		BASE64Encoder base64 = new BASE64Encoder();
		// String encoding =Base64.
		String id = "Junior Hu:wo2hujie";
		String encoding = base64.encode(id.getBytes());
		String url_string = url_pre + "api/2/search?project='Lustre'&startAt=0&maxResults=5";
		//HttpClient httpClient = new DefaultHttpClient();
		try {
	
			URL url = new URL(url_string);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Basic " + encoding);

			byte[] buffer = new byte[1024];
			InputStream in = (InputStream) connection.getInputStream();

			int bytesRead = 0;
			BufferedInputStream bis = new BufferedInputStream(in);
			while ((bytesRead = bis.read(buffer)) != -1) {
				String chunk = new String(buffer, 0, bytesRead);
				System.out.println(chunk);
			}
		} catch (Exception exception) {

			exception.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JiraTest tl = new JiraTest();
		tl.connectJira();
	}

}
