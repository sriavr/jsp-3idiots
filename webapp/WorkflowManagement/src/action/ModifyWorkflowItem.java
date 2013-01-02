package action;

import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyWorkflowItem extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int wftypeid;
	public int getWftypeid() {
		return wftypeid;
	}




	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}




	public int getWfitemid() {
		return wfitemid;
	}




	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
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




	public String getSubmit() {
		return submit;
	}




	public void setSubmit(String submit) {
		this.submit = submit;
	}




	public WorkflowItem getWfitem() {
		return wfitem;
	}




	public void setWfitem(WorkflowItem wfitem) {
		this.wfitem = wfitem;
	}




	public ArrayList<WorkflowItem> getWorkflow() {
		return workflow;
	}




	public void setWorkflow(ArrayList<WorkflowItem> workflow) {
		this.workflow = workflow;
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




	private int wfitemid;
	private String wfitemname;
	private String wfitemcategory;
	private String wfitemtype;
    private int quantityavail; 
    private String submit;
    
    WorkflowItem wfitem =  new WorkflowItem();	
    
    private ArrayList<WorkflowItem> workflow;
    Map<String, Object> session;
    
    
    
	
	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
		if(submit.startsWith("Modify")){
		
		wfitem.setWftypeid(wftypeid);
		wfitem.setWfitemid(wfitemid);
		wfitem.setWfitemname(wfitemname);
		wfitem.setWfitemcategory(wfitemcategory);
		wfitem.setWfitemtype(wfitemtype);
		wfitem.setQuantityavail(quantityavail);
		System.out.println("Wfitem values : "+wfitem.getWftypeid()+" "+wfitem.getWfitemname());
		wfitem.update();
		System.out.println("Modified Wfitem successfully");
		addActionError(getText("Modify Wfitem Successful"));
		return "modifysuccess";
		}
		
		if(submit.startsWith("Delete"))
		{
			session = ActionContext.getContext().getSession();
			
			wfitem.setWftypeid(wftypeid);
			wfitem.setWfitemid(wfitemid);
			wfitem.setWfitemname(wfitemname);
			wfitem.setWfitemtype(wfitemtype);
			wfitem.setWfitemcategory(wfitemcategory);
			wfitem.setQuantityavail(quantityavail);
			wfitem.delete();	
			
			workflow=WorkflowItem.selectall("");
			for(int i=0;i<workflow.size();i++) {
				System.out.println(workflow.get(i).getWftypeid()+" "+workflow.get(i).getWfitemname());
			}
			session.put("workflowitemsession", workflow);
		
	        addActionError(getText("Deleted Workflow Item Successfully"));
	        return "deletesuccess";
		}   
	    


		addActionError(getText("Invalid Modify Role!"));
        return "error";
	} 

}
