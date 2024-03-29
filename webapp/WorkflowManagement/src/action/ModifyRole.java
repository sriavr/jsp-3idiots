package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyRole extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int roleid;
	private int wftypeid;
	private String rolename;
    private String roledescription; 
    private String submit;
    
    Role role =  new Role();	
    
    
    
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getRoleid() {
		return roleid;
	}
    
	public void setRoleid(int roleid) {
		this.roleid = roleid;
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

	public ArrayList<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(ArrayList<Role> rolelist) {
		this.rolelist = rolelist;
	}

	private ArrayList<Role> rolelist;
    Map<String, Object> session;
    
	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
		if(submit.startsWith("Modify")){
		
		role.setRoleid(roleid);
		role.setWftypeid(wftypeid);
		role.setRolename(rolename);
		role.setRoledescription(roledescription);
		System.out.println("Role values : "+role.getRoleid()+" "+role.getWftypeid()+" "+role.getRolename()+" "+role.getRoledescription());
		role.update();
		System.out.println("Modified role successfully");
		addActionMessage(getText("Modify Role Successful"));
		return "modifysuccess";
		}

		if(submit.startsWith("Delete")){
			
			Role role = new Role();
			session = ActionContext.getContext().getSession();
			
			role.setRoleid(roleid);
			role.setWftypeid(wftypeid);
			role.setRolename(rolename);
			role.setRoledescription(roledescription);
			role.delete();
			
			System.out.println("After delete in role");
			
			rolelist = Role.selectall("");
	    	for(int i=0;i<rolelist.size();i++)
	    		System.out.println("Roles Info "+ rolelist.get(i).getRoleid()+" "+rolelist.get(i).getWftypeid()+" "+rolelist.get(i).getRolename());
	    	session.put("rolesession", rolelist);
			
			addActionMessage(getText("Delete Role Successful"));
	        return "deletesuccess";
	}



		
		addActionError(getText("Invalid Modify Role!"));
        return "error";
	} 

}
