package action;
import models.*;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;

public class AddActions {

	private int wftypeid;
	private String actionname;
	private String actiondescription;
	
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
	public String execute()
	{
		System.out.println("Execute of add action");
		
		
		Actions action = new Actions();
		
		if(this.actionname.isEmpty() && this.wftypeid==0)
			return "initial";
		action.setActionid(this.actionid);
		action.setWftypeid(this.wftypeid);
		action.setActionname(this.actionname);
		action.setActiondescription(this.actiondescription);
		action.insert();
		return "success";
		
} 

}
	
	

