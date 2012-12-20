package action;

import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyWorkflowType extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int wftypeid;
	private String wfname;
    private String description; 
    private String submit;
    
    Workflow wf =  new Workflow();	
    
    private ArrayList<Workflow> workflow;
    Map<String, Object> session;
    
    
    
	public int getWftypeid() {
		return wftypeid;
	}



	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}



	public String getWfname() {
		return wfname;
	}



	public void setWfname(String wfname) {
		this.wfname = wfname;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getSubmit() {
		return submit;
	}



	public void setSubmit(String submit) {
		this.submit = submit;
	}



	public Workflow getWf() {
		return wf;
	}



	public void setWf(Workflow wf) {
		this.wf = wf;
	}



	public ArrayList<Workflow> getWorkflow() {
		return workflow;
	}



	public void setWorkflow(ArrayList<Workflow> workflow) {
		this.workflow = workflow;
	}



	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
		if(submit.startsWith("Modify")){
		
		wf.setWftypeid(wftypeid);
		wf.setWfname(wfname);
		wf.setDescription(description);
		System.out.println("Wf values : "+wf.getWftypeid()+" "+wf.getWfname()+" "+wf.getDescription());
		wf.update();
		System.out.println("Modified Wf successfully");
		addActionError(getText("Modify Wf Successful"));
		return "modifysuccess";
		}

		addActionError(getText("Invalid Modify Role!"));
        return "error";
	} 

}
