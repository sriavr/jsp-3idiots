package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyAction extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int actionid;
	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
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

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
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

	private int wftypeid;
	private String actionname;
    private String actiondescription; 
    private String submit;
    
    Action action =  new Action();	
    
    
    
    	public ArrayList<Action> getActionlist() {
		return actionlist;
	}

	public void setActionlist(ArrayList<Action> actionlist) {
		this.actionlist = actionlist;
	}

	private ArrayList<Action> actionlist;
    Map<String, Object> session;
    
	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
		if(submit.startsWith("Modify")){
		
		action.setActionid(actionid);
		action.setWftypeid(wftypeid);
		action.setActionname(actionname);
		action.setActiondescription(actiondescription);
		System.out.println("Action values : "+action.getActionid()+" "+action.getWftypeid()+" "+action.getActionname()+" "+action.getActiondescription());
		action.update();
		System.out.println("Modified action successfully");
		addActionMessage(getText("Modify Action Successful"));
		return "modify_success";
		}

		if(submit.startsWith("Delete")){
			
			Action action = new Action();
			session = ActionContext.getContext().getSession();
			
			action.setActionid(actionid);
			action.setWftypeid(wftypeid);
			action.setActionname(actionname);
			action.setActiondescription(actiondescription);
			action.delete();
			
			System.out.println("After delete in action");
			
			actionlist = Action.selectall("");
	    	for(int i=0;i<actionlist.size();i++)
	    		System.out.println("Action Info "+ actionlist.get(i).getActionid()+" "+actionlist.get(i).getWftypeid()+" "+actionlist.get(i).getActionname());
	    	session.put("rolesession", actionlist);
			
			addActionMessage(getText("Delete Action Successful"));
	        return "delete_success";
	}



		
		addActionError(getText("Invalid Modify Role!"));
        return "error";
	} 

}
