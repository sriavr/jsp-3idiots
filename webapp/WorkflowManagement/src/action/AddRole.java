package action;

import java.util.ArrayList;

import models.*;
import utils.*;
import com.opensymphony.xwork2.ActionSupport;

public class AddRole extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int roleid;
	private int wftypeid;
	private String rolename;
    private String description; 
    private ArrayList<Role> rolelist = new ArrayList<Role>();
    
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
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
		
			Role role = new Role();
			if(this.rolename.isEmpty())
				return "initial";
			role.setRoleid(roleid);
			role.setWftypeid(wftypeid);
			role.setRolename(rolename);
			role.setDescription(description);
			role.insert();
	        rolelist=Role.selectall("");
	        return "success";
	} 

}
