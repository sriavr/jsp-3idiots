package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
    
	private static final long serialVersiopackage action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private WorkflowTypeDetails wfTypeDetails = new WorkflowTypeDetails();
	private String username = "";
	private String password = "";
	private String member = "";
	private String administrator = "";
	private String submit = "";
	private String user = "";
	private String rolename = "";
	private int wftypeid;
	private String wfname;
	private String button_name;
	private ArrayList<Admin> adminlist = new ArrayList<Admin>();
	ArrayList<Member> memberlist = new ArrayList<Member>();
	ArrayList<Role> rolelist = new ArrayList<Role>();
	ArrayList<WorkflowType> workflow = new ArrayList<WorkflowType>();
	Map<String, Object> session;
	ArrayList<WorkflowInstance_member> wfinstances_member = new ArrayList<WorkflowInstance_member>();
	ArrayList<WorkflowCategory> wfcategories = new ArrayList<WorkflowCategory>();

	private ArrayList<WorkflowDataAll> wfdatadef = new ArrayList<WorkflowDataAll>();

	public WorkflowTypeDetails getWfTypeDetails() {
		return wfTypeDetails;
	}

	public void setWfTypeDetails(WorkflowTypeDetails wfTypeDetails) {
		this.wfTypeDetails = wfTypeDetails;
	}

	public ArrayList<WorkflowDataAll> getWfdatadef() {
		return wfdatadef;
	}

	public void setWfdatadef(ArrayList<WorkflowDataAll> wfdatadef) {
		this.wfdatadef = wfdatadef;
	}

	public String getButton_name() {
		return button_name;
	}

	public void setButton_name(String button_name) {
		this.button_name = button_name;
	}

	public String getWfname() {
		return wfname;
	}

	public void setWfname(String wfname) {
		this.wfname = wfname;
	}

	private WorkflowType wf = new WorkflowType();
	Member member_loggedin;

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public ArrayList<WorkflowCategory> getWfcategories() {
		return wfcategories;
	}

	public void setWfcategories(ArrayList<WorkflowCategory> wfcategories) {
		this.wfcategories = wfcategories;
	}

	public ArrayList<WorkflowInstance_member> getWfinstances_member() {
		return wfinstances_member;
	}

	public void setWfinstances_member(
			ArrayList<WorkflowInstance_member> wfinstances_member) {
		this.wfinstances_member = wfinstances_member;
	}

	public Member getMember_loggedin() {
		return member_loggedin;
	}

	public void setMember_loggedin(Member member_loggedin) {
		this.member_loggedin = member_loggedin;
	}

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
		/*
		 * MyLog.log("in Login.execute() with submit = " + this.submit);
		 */
		/*
		 * System.out.println("in Login.execute() with submit = " +
		 * this.submit);
		 */

		session = ActionContext.getContext().getSession();
		boolean isLoggedIn = false;
		boolean isAdmin = false;
		System.out.println("checking session");
		if (session != null && session.get("memberloggedin") != null) {
			isLoggedIn = true;
			Member loggedInUser = (Member) session.get("memberloggedin");
			System.out.println("User is already logged in");
			if ((Boolean) session.get("isAdmin")) {
				isAdmin = true;
			} else {
				isAdmin = false;
			}
		} else if (username.isEmpty() || password.isEmpty()) {
			System.out.println("User is not logged in");
			return "initial_entry";
		}

		if (!isLoggedIn) {
			isAdmin = !(this.user.equalsIgnoreCase("member"));
		}

		if (!isAdmin && !isLoggedIn) {
			System.out.println("In login member");
			// int flag = 0;
			System.out.println("selecting members");
			memberlist = Member.selectall("");
			System.out.println("memberlist size" + memberlist.size());
			/*
			 * rolelist = Role.selectall("");
			 * 
			 * for(int i=0;i<rolelist.size();i++)
			 * System.out.println(rolelist.get(i).getRolename());
			 */

			for (int i = 0; i < memberlist.size(); i++) {
				if (this.username.equals(memberlist.get(i).getUsername())
						&& this.password
								.equals(memberlist.get(i).getPassword())) {
					System.out.println("found a match in members");
					session = ActionContext.getContext().getSession();
					session.put("memberloggedin", memberlist.get(i));
					System.out.println(" wftypeid of user set is "
							+ memberlist.get(i).getRole().getWorkflowType()
									.getWftypeid());
					System.out.println("Setting admin as false");
					session.put("isAdmin", false);
					System.out.println("usrname has been selected");
					isLoggedIn = true;
					break;
				}
			}

			if (isLoggedIn) {
				session = ActionContext.getContext().getSession();
				member_loggedin = (Member) session.get("memberloggedin");
				// wfinstances_member = WorkflowInstance_member
				// .selectall(member_loggedin.getMemberid());
				// wfcategories = WorkflowCategory.selectall("");
				// System.out.println("WFInstance_Member");
				// for (int i = 0; i < wfinstances_member.size(); i++)
				// System.out.println(wfinstances_member.get(i)
				// .getWfcategoryname()
				// + " "
				// + wfinstances_member.get(i).getWftypeid());

				// wfinstances_member =
				// WorkflowInstance_member.selectall(member_loggedin.getMemberid());

				int roleid = member_loggedin.getRole().getRoleid();
				wftypeid = member_loggedin.getRole().getWorkflowType()
						.getWftypeid();
				// wfcategories = WorkflowCategory.selectall(" where wftypeid="
				// + wftypeid);
				// // wf = WorkflowType.selectone(" where wftypid="+wftypeid);
				wfname = member_loggedin.getRole().getWorkflowType()
						.getWfname();
				// wfdatadef = WorkflowDataAll.selectalldef(" where wftypeid="
				// + wftypeid);

				if (wftypeid == 0) {
					System.out.println("No workflow type selected");
					return ERROR;
				} else {
					System.out
							.println("Running WorkflowTypeDetails.selectone()");
					wfTypeDetails
							.setAssociatedWorkflowInstances(WorkflowTypeDetails
									.selectallInstancesMember(member_loggedin
											.getMemberid()));
					System.out.println("Size of associateWorkflowInstances:"
							+ wfTypeDetails.getAssociatedWorkflowInstances()
									.size());
					this.setWfTypeDetails(wfTypeDetails);
				}

				return "success_member";
			}
		}

		else {
			isLoggedIn = false;
			System.out.println("admin is loggedin");
			adminlist = Admin.selectall("");
			System.out.println("checking admin login");
			for (int i = 0; i < adminlist.size(); i++)
				System.out.println("Admin details "
						+ adminlist.get(i).getUsername() + " "
						+ adminlist.get(i).getPassword());
			for (int i = 0; i < adminlist.size(); i++) {
				if (this.username.equals(adminlist.get(i).getUsername())
						&& this.password.equals(adminlist.get(i).getPassword())) {
					System.out.println("admin match found");
					session = ActionContext.getContext().getSession();
					session.put("loggedin", adminlist.get(i));
					session.put("isAdmin", true);
					isLoggedIn = true;
					break;
				}
			}
			if (isLoggedIn) {
				// this.workflow = Workflow.selectall("");
				System.out.println("successfully logged in");
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
nUID = 1L;
		
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
