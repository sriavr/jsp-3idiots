package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayRole extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String radioroleid;
	private int roleid;
	private int wftypeid;
	private String rolename;
    private String roledescription; 
    private String submit;
    Role role=new Role();
    

	public String getRadioroleid() {
		return radioroleid;
	}

	public void setRadioroleid(String radioroleid) {
		this.radioroleid = radioroleid;
	}

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
		
		if(submit.startsWith("Display")){
		System.out.println("radioroleid "+radioroleid);
		role=Role.selectOne("where roleid="+radioroleid);
		System.out.println("role info fetched");
		this.setRoleid(Integer.parseInt(radioroleid));
		this.setWftypeid(role.getWftypeid());
		this.setRolename(role.getRolename());
		this.setRoledescription(role.getRoledescription());
		System.out.println(getRoleid()+" "+getRolename()+" "+getWftypeid()+" "+getRoledescription());
		return "displaysuccess";
		}

		if(submit.startsWith("Back"))
		{
			return "back";
		}
			
		addActionError(getText("Invalid Display Role!"));
        return "error";
	} 

}
