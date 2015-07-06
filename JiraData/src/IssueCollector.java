import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import com.atlassian.jira.rest.client.JiraRestClient;
import com.atlassian.jira.rest.client.JiraRestClientFactory;

import com.atlassian.jira.rest.client.domain.BasicIssue;
import com.atlassian.jira.rest.client.domain.BasicProject;
import com.atlassian.jira.rest.client.domain.Issue;
import com.atlassian.jira.rest.client.domain.User;
import com.atlassian.jira.rest.client.domain.input.FieldInput;
import com.atlassian.jira.rest.client.domain.input.IssueInput;
import com.atlassian.jira.rest.client.domain.input.IssueInputBuilder;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
 
public class IssueCollector {
 
 
 static JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();

 static String uri="http://jira.intel.hpdd.com";
 static String user="Junior Hu";
 static String pwd="wo2hujie";
 /**
 * @param args
 */
 public static void main(String[] args) {
 // TODO Auto-generated method stub
 
 
 }
 public static void getIssue(String issueKey) throws URISyntaxException{
  
 URI jiraServerUri = new URI(uri);
 JiraRestClient restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, user, pwd);
 //get issue through issueKey
 Issue issue = restClient.getIssueClient().getIssue(issueKey);
 //grab user info
 User usr = restClient.getUserClient().getUser(user); 
 System.out.println(usr);
 System.out.println(issue);
 }
  
 //
 /*
 * create the issue
 * @param Issue type :  1L:bug; 2L:new requirement; 3L:task; 4L.improvement
 * @param projectName:such as "GTP",the project short name
 * @param Longid:such as 10000
 * @param Summary:topic
 * @param Description:
 */
public static void createIssue(String projectName,String issueType,String description,String summary) throws URISyntaxException{
 //JerseyJiraRestClientFactory factory = new JerseyJiraRestClientFactory();
 URI jiraServerUri = new URI(uri);
 JiraRestClient restClient = factory.createWithBasicHttpAuthentication(
 jiraServerUri, user, pwd);
 IssueInputBuilder issueBuilder = new IssueInputBuilder("ProjectKey",
 Long.valueOf(issueType));
 
 
 final URI projectUri = new URI(
 "http://localhost:8100/rest/api/2/project/IT");
 BasicProject bporject = new BasicProject(projectUri, projectName, "",(long) 10000);
 issueBuilder.setProject(bporject);
 issueBuilder.setDescription(description);
 issueBuilder.setSummary(summary);
 
 
 IssueInput issueInput = issueBuilder.build();
 BasicIssue bIssue = restClient.getIssueClient().createIssue(issueInput,
 pm);
 // print the newly created issuekey
 System.out.println(bIssue.getKey());
 } <span></span> public static void updateIssueField(String key,String field,String value) throws URISyntaxException{
 
 
 URI jiraServerUri = new URI(uri);
 JiraRestClient restClient = factory.createWithBasicHttpAuthentication(
 jiraServerUri, user, pwd);
 //get the issue through issuekey
 Issue issue = restClient.getIssueClient().getIssue(key);
 //update the default field environment,if the field is defined by self,pls use the filed<span></span> FieldInput fieldinput = new FieldInput("environment", value);
 List<FieldInput> fields = new ArrayList<FieldInput>();
 fields.add(fieldinput);
 restClient.getIssueClient().update(issue, fields);
 }
 
 
public static void changeIssueStatus(String issuekey) throws URISyntaxException
 {
 
 
 URI jiraServerUri = new URI(uri);
 JiraRestClient restClient = factory
 .createWithBasicHttpAuthentication(jiraServerUri, user,
 pwd);               
 Issue issue = restClient.getIssueClient().getIssue(issuekey);
//the number 3 is involed below picture,you can focus on the red rectangular
 TransitionInput tinput= new TransitionInput(3);
 restClient.getIssueClient().transition(issue,
 tinput, pm);
 }  }