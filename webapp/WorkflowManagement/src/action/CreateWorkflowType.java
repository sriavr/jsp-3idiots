package action;

import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateWorkflowType extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int rolewftypeid;
	private int wftypeid;
	private String wfname;
    private String description; 
    private String submit;
    private ArrayList<Workflow> workflow;
    private ArrayList<Workflow> viewwflist= new ArrayList<Workflow>();
    Workflow wf = new Workflow();
    
    Map<String,Object> session;
    
    
	public ArrayList<Workflow> getViewwflist() {
		return viewwflist;
	}

	public void setViewwflist(ArrayList<Workflow> viewwflist) {
		this.viewwflist = viewwflist;
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

	
	private void addToWorkflow(Workflow wf)
	{
		workflow=Workflow.selectall("");
		for(int i=0;i<workflow.size();i++) {
			System.out.println(workflow.get(i).getWftypeid()+" "+workflow.get(i).getWfname());
		}
		session.put("workflowsession", workflow);
		
	}
	
	private void settypeid()
	{
		workflow=Workflow.selectall("");
		for(int i=0;i<workflow.size();i++) {
			setRolewftypeid(workflow.get(i).getWftypeid());
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
			Workflow wf = new Workflow();
			session = ActionContext.getContext().getSession();
			if(session.get("workflowsession")==null)
			{
				session.put("workflowsession", new ArrayList<Workflow>());
			}
			this.workflow=(ArrayList<Workflow>)session.get("workflowsession");
			
			if(this.wfname.isEmpty())
				return "initial";
			
			wf.setWftypeid(wftypeid);
			wf.setWfname(wfname);
			wf.setDescription(description);
			wf.insert();	
	        addToWorkflow(wf);
	        addActionError(getText("Created Workflow Successfully"));
	        return "createsuccess";
		}   
	        
		if(submit.startsWith("View")){
			workflow=new ArrayList<Workflow>();
			workflow=Workflow.selectall("");
			for(int i=0;i<workflow.size();i++)
			{
				wf=workflow.get(i);
				viewwflist.add(wf);
				System.out.println(viewwflist.get(i).getWftypeid()+" "+viewwflist.get(i).getWfname()+" "+viewwflist.get(i).getDescription());
			}
			return "viewsuccess";
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
