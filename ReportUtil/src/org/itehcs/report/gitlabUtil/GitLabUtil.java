package org.itehcs.report.gitlabUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.itehcs.report.commom.HttpUtil;
import org.itehcs.report.commom.JsonUtil;

public class GitLabUtil {

	//¥¶¿Ìgitlab
	String URLprefix = "http://124.16.141.145/api/v3/projects/9/";
	String token = "private_token=Ss5iPJZqyDXP_CChyXWq";
	String url = "";
	Pattern emailer = Pattern.compile("@[\\w[.-]+\\.[\\w]]+");  
	HttpUtil hu = new HttpUtil();
	public GitLabUtil(String command){
		
		this.url = URLprefix + command+ "?" + token;
	}
	public void parsingMergeComments(){
		
		String json_str = hu.retrStr(url);
		System.out.println(json_str);
	}
	public void parsingMergeRequest(){
		
		
		String json_str = hu.retrStr(url);
		json_str = json_str.replaceAll("\\\\r\\\\n\\\\r\\\\n", " ");
		json_str = json_str.replaceAll("\\\\r\\\\n", " ");
		//System.out.println(json_str);
		List<Object> list_m = new ArrayList<Object>();
		
		JsonUtil ju = new JsonUtil(json_str);
		MergeRequest mr= new MergeRequest();
		
			list_m = ju.parsingJsonObject(mr);
		
		//System.out.println(list_m);
		for(int i = 0 ; i < list_m.size(); i++ ){
			
			MergeRequest mrr = (MergeRequest) list_m.get(i);
			//System.out.println(mrr.getDescription());
			Matcher matchr = emailer.matcher(mrr.getDescription());
			while (matchr.find()) {  
				 String email = matchr.group();  
			     System.out.println(email);  
			  } 
			 
			System.out.println("vote"+ mrr.getUpvotes());
			
			System.out.println("----------------------------");

			
		}
		//System.out.println(list_m.size());
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GitLabUtil ga = new GitLabUtil("merge_requests");
		ga.parsingMergeRequest();
		//GitLabUtil ga = new GitLabUtil("merge_requests/540/comments");
		//ga.parsingMergeComments();

	}

}
