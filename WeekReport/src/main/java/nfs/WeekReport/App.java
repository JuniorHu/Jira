package nfs.WeekReport;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.JiraRestClientFactory;
//import com.atlassian.jira.rest.client.domain.BasicIssue;
//import com.atlassian.jira.rest.client.domain.BasicProject;
//import com.atlassian.jira.rest.client.domain.Issue;
import com.atlassian.jira.rest.client.domain.User;
//import com.atlassian.jira.rest.client.domain.input.FieldInput;
//import com.atlassian.jira.rest.client.domain.input.IssueInput;
//import com.atlassian.jira.rest.client.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
/**
 * connect jira
 *
 */
public class App {
	private static boolean initSuccess = false;
	private static String user="nfs";
	private static String pwd="nfs";
	public static void main(String[] args){
		try{
			    JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
				URI jiraServerUri = new URI("https://192.168.12.35:8080");
				
				JiraRestClient restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, user,pwd);
		        initSuccess = true;
		        System.out.println("Create sucess");
			}catch(Exception ex){
				initSuccess = false;
				System.out.println("Create failed");
			}
		}
}



