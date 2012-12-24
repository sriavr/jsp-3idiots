package action;

import java.util.ArrayList;
import java.util.Map;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberFunctions extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String submit; 
    private ArrayList<Workflow> workflow = new ArrayList<Workflow>();
    private ArrayList<String> membertype = new ArrayList<String>();
	private ArrayList<Role> rolelist = new ArrayList<Role>();
	private ArrayList<String> rolenames = new ArrayList<String>();
	private String rolename;
	
	
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public ArrayList<String> getRolenames() {
		return rolenames;
	}

	public void setRolenames(ArrayList<String> rolenames) {
		this.rolenames = rolenames;
	}

	public ArrayList<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(ArrayList<Role> rolelist) {
		this.rolelist = rolelist;
	}

		
	public ArrayList<String> getMembertype() {
		return membertype;
	}

	public void setMembertype(ArrayList<String> membertype) {
		this.membertype = membertype;
	}

	public ArrayList<Workflow> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<Workflow> workflow) {
		this.workflow = workflow;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	String ret_val;

	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		if (submit.startsWith("Next")) {
			rolelist = Role.selectall("");
			for(int i=0;i<rolelist.size();i++)
			{
				rolename=rolelist.get(i).getRolename();
				rolenames.add(rolename);
			}
			
			for(int i=0;i<membertype.size();i++)
			{
				for(int j=0;j<rolenames.size();j++)
				{
					if(membertype.get(i).matches(rolenames.get(j)))
					{
						ret_val=rolenames.get(j);
						break;
					}
				}
					
			}
			
			return ret_val;
		
        }

		
			addActionError(getText("Invalid"));
	        return "error";
	        		
	}
        

 
}
