package action;

import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddRole extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int memberroleid;
	private int roleid;
	private int wftypeid;
	private String rolename;
    private String roledescription; 
    private String submit;
    
    private ArrayList<Role> rolelist;
    Map<String, Object> session;
    
    private void addToRole(Role role)
	{ 
		/*if(this.rolelist==null)
		{
			rolelist=new ArrayList<Role>();
		}
		rolelist.add(role);
		*/
    	rolelist = Role.selectall("");
    	for(int i=0;i<rolelist.size();i++)
    		System.out.println("Roles Info "+ rolelist.get(i).getRoleid()+" "+rolelist.get(i).getWftypeid()+" "+rolelist.get(i).getRolename());
    	session.put("rolesession", rolelist);
		
	}
    
    
	private void setroleid()
	{
		rolelist=Role.selectall("");
		for(int i=0;i<rolelist.size();i++) {
			setMemberroleid(rolelist.get(i).getRoleid());
		}
	}

	

	public int getMemberroleid() {
		return memberroleid;
	}


	public void setMemberroleid(int memberroleid) {
		this.memberroleid = memberroleid;
	}


	public int getRoleid() {
		return roleid;
	}




	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}




	public String getRoledescription() {
		return roledescription;
	}




	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}




	public String getSubmit() {
		return submit;
	}




	public void setSubmit(String submit) {
		this.submit = submit;
	}




	public int getWftypeid() {
		return wftypeid;
	}



	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
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



	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		if(submit.startsWith("Add")){
			
			if(this.rolename.isEmpty())
	        {
		        addActionError(getText("Invalid  Add Role!"));
			    return "error";
	        }
				Role role = new Role();
				session = ActionContext.getContext().getSession();
				if(session.get("rolesession")==null)
				{
					session.put("rolesession", new ArrayList<Role>());
				}
				this.rolelist=(ArrayList<Role>)session.get("rolesession");
				
				if(this.rolename.isEmpty())
					return "initial";
				role.setRoleid(roleid);
				role.setWftypeid(wftypeid);
				role.setRolename(rolename);
				role.setRoledescription(roledescription);
				role.insert();
				System.out.println("After insert in role");
				addToRole(role);
				addActionError(getText("Add Role Successful"));
		        return "success";
		}
		
		if(submit.startsWith("Next"))
		{
			setroleid();
			System.out.println("MemberRoleid "+getMemberroleid());
	        return "next";
		}
		
		addActionError(getText("Invalid Add Role!"));
        return "error";
	} 

}
