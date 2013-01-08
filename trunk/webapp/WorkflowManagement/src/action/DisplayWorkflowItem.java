package action;
import java.math.BigDecimal;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.Member;
import model.Role;
import model.WorkflowItem;

public class DisplayWorkflowItem extends ActionSupport {
	
	private int wfitemid;
	private int wftypeid;
	private String wfitemname;
	private String wfitemcategory;
	private String wfitemtype;
	private int quantityavail;
	
	
	private String submit;
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
		WorkflowItem wfitem =new WorkflowItem();
	ArrayList<WorkflowItem> workflowitemlist =new ArrayList<WorkflowItem>();
	Map<String, Object> session;
	private String radioworkflowitemid;
	
	
	public int getWfitemid() {
		return wfitemid;
	}
	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
	}
	public int getWftypeid() {
		return wftypeid;
	}
	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}
	public String getWfitemname() {
		return wfitemname;
	}
	public void setWfitemname(String wfitemname) {
		this.wfitemname = wfitemname;
	}
	public String getWfitemcategory() {
		return wfitemcategory;
	}
	public void setWfitemcategory(String wfitemcategory) {
		this.wfitemcategory = wfitemcategory;
	}
	public String getWfitemtype() {
		return wfitemtype;
	}
	public void setWfitemtype(String wfitemtype) {
		this.wfitemtype = wfitemtype;
	}
	public int getQuantityavail() {
		return quantityavail;
	}
	public void setQuantityavail(int quantityavail) {
		this.quantityavail = quantityavail;
	}
	public WorkflowItem getWfitem() {
		return wfitem;
	}
	public void setWfitem(WorkflowItem wfitem) {
		this.wfitem = wfitem;
	}
	public ArrayList<WorkflowItem> getWorkflowitemlist() {
		return workflowitemlist;
	}
	public void setWorkflowitemlist(ArrayList<WorkflowItem> workflowitemlist) {
		this.workflowitemlist = workflowitemlist;
	}
	public String getRadioworkflowitemid() {
		return radioworkflowitemid;
	}
	public void setRadioworkflowitemid(String radioworkflowitemid) {
		this.radioworkflowitemid = radioworkflowitemid;
	}
	public  String execute()
	{
		
		
				 
		if(this.submit.startsWith("Delete"))
		{
			
				
				System.out.println("radioworkflowitemid  -->"+radioworkflowitemid);
				
				wfitem.setWfitemid(Integer.parseInt(radioworkflowitemid));
				/*member.setFname(fname);
				member.setLname(lname);
				member.setEmailid(emailid);
				member.setPhone(phone);
				member.setUsername(username);
				member.setPassword(password);
				member.setAddress(address);
				*/
				wfitem.delete();
				
				System.out.println("After delete in item");
				
				workflowitemlist = wfitem.selectall("");
		    	for(int i=0;i<workflowitemlist.size();i++)
		    		System.out.println("Item Info "+ workflowitemlist.get(i).getWfitemid());
		    	session.put("workflowitemsession", workflowitemlist);
				
//				/addActionMessage(getText("Delete Member Successful"));
		        
					
		
			return "delete_success";
		}
		if(this.submit.startsWith("Display"))
			{
			
			
				System.out.println("radioworkflowitemid "+radioworkflowitemid);
				wfitem=wfitem.selectOne("where wfitemid="+radioworkflowitemid);
				System.out.println("item info fetched");
				this.setWfitemid(Integer.parseInt(radioworkflowitemid));
				this.setWftypeid(wfitem.getWftypeid());
				this.setWfitemname(wfitem.getWfitemname());
				this.setWfitemcategory(wfitem.getWfitemcategory());
				this.setQuantityavail(wfitem.getQuantityavail());
				this.setWfitemtype(wfitem.getWfitemtype());
				
		
				System.out.println(getWfitemid());
				return "display_success";
			}
		
			
		/*if(this.submit.startsWith("Back"))
		return "back";
*/		
	
        	return "null";
	}
}
