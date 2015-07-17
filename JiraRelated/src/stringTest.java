
public class stringTest {
	
	public static void main(String[] args){
		String s="LU-6747 osd-zfs: initialize obd_statfs in osd_statfs()\n"
				+"The osd-zfs osd_statfs() method wasn't initializing all of the fields\n"
	            +"of struct obd_statfs, and in some cases could be returning random\n"
				+"data to the client.  For most of the fields this doesn't matter, but\n"
	            +"the os_state field could contain OS_STATE_READONLY and prevent the\n"
				+"MDS from allocating objects there.";
		
		int temp=0;
		for(int i=0;i<s.length();i++) {
			char k=s.charAt(i);
			if(k=='\n'){
				temp=i;
				i=s.length();
			
			}
		}
		String str=s.substring(0,temp);
		System.out.print(str);
	}
	

}
