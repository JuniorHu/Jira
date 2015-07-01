import 
public class JiraConnection {
	private JiraRestClient restClient;
	private NullProgressMonitor pm;
	private boolean initSuccess = false;
	
	public JiraConnection(){
		try{
			JerseyJiraRestClientFactory factory = new JerseyJiraRestClientFactory();
			URI jiraServerUri = new URI("https://jira.hpdd.intel.com");
	        AnonymousAuthenticationHandler anonymousHandler = new AnonymousAuthenticationHandler();
	        restClient = factory.create(jiraServerUri, anonymousHandler);
	        pm = new NullProgressMonitor();
	        
	        initSuccess = true;
		}catch(Exception ex){
			initSuccess = false;
		}
	}

}
