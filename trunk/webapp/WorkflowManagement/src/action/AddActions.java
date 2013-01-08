package action;
import model.*;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddActions extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int wftypeid;
	private String actionname;
	private String actiondescription;
	private String submit;
	
	
	ArrayList<Action>  actionlist;
	public ArrayList<Action> getActionlist() {
		return actionlist;
	}
	Map<String,Object> session; 
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}
	Action action=new Action();
	public void addToAction()
	{
		
		actionlist = action.selectall(""); 
		for(int i=0;i<actionlist.size();i++)
			System.out.println("wftypeid"+" "+actionlist.get(i).getWftypeid()+" "+"actionname"+" "+actionlist.get(i).getActionname());
		session.put("actionsession" , actionlist);
		
	}
	public void setActionlist(ArrayList<Action> actionlist) {
		this.actionlist = actionlist;
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
		
		
		
		actionlist =  new ArrayList<Action>();
		if(this.actionname.isEmpty() && this.wftypeid==0)
			return "initial";
		
		if(this.submit.startsWith("Add"))
		{
		session = ActionContext.getContext().getSession();
		
		if(session.get("actionsession")==null)
		{
			session.put("actionsession", new ArrayList<Action>());
		}
		this.actionlist=(ArrayList<Action>)session.get("actionsession");
		action.setWftypeid(this.wftypeid);
		action.setActionname(this.actionname);
		action.setActiondescription(this.actiondescription);
		System.out.println(wftypeid+" "+actionname+" "+actiondescription);
		action.insert();
		System.out.println(" action successfully added");
		
		this.actionname =" ";
		this.actiondescription=" ";
	
		return "addsuccess";
		
		}
		
		if(this.submit.startsWith("View"))
		{
			actionlist =action.selectall("");
				for(int i=0;i<actionlist.size();i++)
					System.out.println("actionid"+" "+actionlist.get(i).getActionid()+" "+"wftypeid"+" "+actionlist.get(i).getWftypeid());
					//session.put("actionsession", actionlist);
			return "viewsuccess";
		}
		

		//addActionMessage(getText("Invalid ActionName!!!"));
			return "Error";
		
} 

}
	
	

