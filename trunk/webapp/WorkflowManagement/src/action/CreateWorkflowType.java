package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateWorkflowType extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int rolewftypeid;
	
	private int wftypeid;
	private String wfname;
    private String description; 
    private String submit;
    private ArrayList<WorkflowType> workflow;
    private ArrayList<WorkflowType> viewwflist= new ArrayList<WorkflowType>();
    private ArrayList<String> workflowtypelist= new ArrayList<String>();
    public ArrayList<String> getWorkflowtypelist() {
		return workflowtypelist;
	}

	public void setWorkflowtypelist(ArrayList<String> workflowtypelist) {
		this.workflowtypelist = workflowtypelist;
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


	WorkflowType wf = new WorkflowType();
    
    Map<String,Object> session;
    
    
	public ArrayList<WorkflowType> getViewwflist() {
		return viewwflist;
	}

	public void setViewwflist(ArrayList<WorkflowType> viewwflist) {
		this.viewwflist = viewwflist;
	}

	public WorkflowType getWf() {
		return wf;
	}

	public void setWf(WorkflowType wf) {
		this.wf = wf;
	}

	public ArrayList<WorkflowType> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<WorkflowType> workflow) {
		
		this.workflow = workflow;
	}

	
	private void addToWorkflow(WorkflowType wf)
	{
		workflow=WorkflowType.selectall("");
		for(int i=0;i<workflow.size();i++) {
			System.out.println(workflow.get(i).getWftypeid()+" "+workflow.get(i).getWfname());
		}
		session.put("workflowsession", workflow);
		
	}
	
	private void settypeid()
	{
		workflow=WorkflowType.selectall("");
		for(int i=0;i<workflow.size();i++) {
			setRolewftypeid(workflow.get(i).getWftypeid());
			setWftypeid(workflow.get(i).getWftypeid());
		}
	}
	
	private void settypelist()
	{
		workflow=WorkflowType.selectall("");
		for(int i=0;i<workflow.size();i++) {
			workflowtypelist.add(workflow.get(i).getWfname());
			
		}
	}
	
	

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	
	
	public int getRolewftypeid() {
		return rolewftypeid;
	}

	public void setRolewftypeid(int rolewftypeid) {
		this.rolewftypeid = rolewftypeid;
	}

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


	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
			
		if(submit.startsWith("Create"))
		{
			WorkflowType wf = new WorkflowType();
			session = ActionContext.getContext().getSession();
			if(session.get("workflowsession")==null)
			{
				session.put("workflowsession", new ArrayList<WorkflowType>());
			}
			this.workflow=(ArrayList<WorkflowType>)session.get("workflowsession");
			
			if(this.wfname.isEmpty())
				return "initial";
			
			wf.setWftypeid(wftypeid);
			System.out.println(" ---------------------- "+wftypeid);
			wf.setWfname(wfname);
			wf.setDescription(description);
			wf.insert();	
	        
	        addActionError(getText("Created Workflow Successfully"));
	        return "createsuccess";
		}   
	        
		if(submit.startsWith("View")){
			workflow=new ArrayList<WorkflowType>();
			workflow=WorkflowType.selectall("");
			for(int i=0;i<workflow.size();i++)
			{
				wf=workflow.get(i);
				viewwflist.add(wf);
				System.out.println(viewwflist.get(i).getWftypeid()+" "+viewwflist.get(i).getWfname()+" "+viewwflist.get(i).getDescription());
			}
			return "viewsuccess";
		}
		
		
		if(submit.startsWith("Add")){
			
			return "addsuccess";
		}
	
				
		if(submit.startsWith("Next"))
		{
			settypeid();
			System.out.println("Rolewftypeid "+getRolewftypeid());
	        return "next";
		}
		
		addActionError(getText("Invalid  Create Workflow!"));
	    return "error";
	} 

}
