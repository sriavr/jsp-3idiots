package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String username="";
    private String password=""; 
	private String member="";
    private String administrator="";
    private String submit="";
    private String user="";
    private String rolename="";
    
    ArrayList<Admin> adminlist = new ArrayList<Admin>();
    ArrayList<Member> memberlist = new ArrayList<Member>();
    ArrayList<Role> rolelist = new ArrayList<Role>();
	ArrayList<WorkflowType> workflow = new ArrayList<WorkflowType>();
	Map<String,Object> session;
	
	
	
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public ArrayList<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(ArrayList<Role> rolelist) {
		this.rolelist = rolelist;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public ArrayList<Admin> getAdminlist() {
		return adminlist;
	}

	public void setAdminlist(ArrayList<Admin> adminlist) {
		this.adminlist = adminlist;
	}

	public ArrayList<Member> getMemberlist() {
		return memberlist;
	}

	public void setMemberlist(ArrayList<Member> memberlist) {
		this.memberlist = memberlist;
	}

	public ArrayList<WorkflowType> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<WorkflowType> workflow) {
		this.workflow = workflow;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
	

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}

	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
        /*System.out.println("in Login.execute() with submit = " + 
    	        this.submit); */
	        if (this.username.isEmpty() || this.password.isEmpty()) {
			    return "initial_entry";
	        } 
	        if(this.user.equalsIgnoreCase("member"))
	        {
	        int flag=0;
	        memberlist = Member.selectall("");
	        rolelist = Role.selectall("");
	        for(int i=0;i<rolelist.size();i++)
	        	System.out.println(rolelist.get(i).getRolename());
	        
	        for(int i=0;i<memberlist.size();i++)
	        {
		        if (this.username.equals(memberlist.get(i).getLname()) 
		                && this.password.equals(memberlist.get(i).getPassword())) {
		        	session=ActionContext.getContext().getSession();
		        	session.put("memberloggedin", memberlist.get(i));
		        	System.out.println("usrname has been selected");
					flag=1;
					break;
		            
		        }
	        }
	        if(flag==1)
	        	{
		        	//this.workflow = Workflow.selectall("");
		        	return "success_member";
	        	}
	        }
	        
	        if(this.user.equalsIgnoreCase("administrator"))
	        {
	        int flag=0;
	        adminlist = Admin.selectall("");
	        for(int i=0;i<adminlist.size();i++)
	        	System.out.println("Admin details "+adminlist.get(i).getUsername()+" "+adminlist.get(i).getPassword());
		        for(int i=0;i<adminlist.size();i++)
		        {
			        if (this.username.equals(adminlist.get(i).getUsername()) 
			                && this.password.equals(adminlist.get(i).getPassword())) {
			        	session=ActionContext.getContext().getSession();
			        	session.put("loggedin", adminlist.get(i));
						flag=1;
						break;
			        }
			        
		        }
		        if(flag==1)
		    	{
		        	//this.workflow = Workflow.selectall("");
		        	return "success_admin";
		    	}
	        }
	    addActionError(getText("Incorrect user id and / or password!"));
		return "error";
	}
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
