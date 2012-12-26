package action;

import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayAction extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	public String getRadioactionid() {
		return radioactionid;
	}

	public void setRadioactionid(String radioactionid) {
		this.radioactionid = radioactionid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

	public String getActiondescription() {
		return actiondescription;
	}

	public void setActiondescription(String actiondescription) {
		this.actiondescription = actiondescription;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public ArrayList<Actions> getActionlist() {
		return actionlist;
	}

	public void setActionlist(ArrayList<Actions> actionlist) {
		this.actionlist = actionlist;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String radioactionid;
	private int wftypeid;
	private int actionid;
	
	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

	private String actionname;
    private String actiondescription; 
    private String submit;
    Actions action=new Actions();
    

	private ArrayList<Actions> actionlist;
    Map<String, Object> session;

	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
		if(submit.startsWith("Display")){
		System.out.println("radioactionid "+radioactionid);
		action=Actions.selectOne("where actionid="+radioactionid);
		System.out.println("action info fetched");
		//System.out.println(action.getActionname());
		this.setActionid(Integer.parseInt(radioactionid));
		System.out.println("step1 completed");
		this.setWftypeid(action.getWftypeid());
		System.out.println("step2 completed");
		this.setActionname(action.getActionname());
		System.out.println("step3 completed");
		this.setActiondescription(action.getActiondescription());
		System.out.println("step4 completed");
		System.out.println(getActionid()+" "+getActionname()+" "+getWftypeid()+" "+getActiondescription());
		return "display_success";
		}

		if(this.submit.startsWith("Delete"))
		{
			
				//member.setRoleid(roleid);
				System.out.println("radioactionid  -->"+radioactionid);
				
				action.setActionid(Integer.parseInt(radioactionid));
				/*member.setFname(fname);
				member.setLname(lname);
				member.setEmailid(emailid);
				member.setPhone(phone);
				member.setUsername(username);
				member.setPassword(password);
				member.setAddress(address);
				*/
				action.delete();
				
				System.out.println("After delete in action");
				
				actionlist = action.selectall("");
		    	for(int i=0;i<actionlist.size();i++)
		    		System.out.println("Action Info "+ actionlist.get(i).getActionid());
		    	session.put("actionsession", actionlist);
				
//				/addActionMessage(getText("Delete Member Successful"));
		        
					
		
			return "delete_success";
		}
			
		addActionError(getText("Invalid Display Role!"));
        return "error";
	} 

}
