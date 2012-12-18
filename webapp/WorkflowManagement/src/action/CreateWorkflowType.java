package action;

import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateWorkflowType extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int wftypeid;
	private String wfname;
    private String description; 
    private ArrayList<Workflow> workflow;
    Map<String,Object> session;
    
    
	public ArrayList<Workflow> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<Workflow> workflow) {
		this.workflow = workflow;
	}

	
	private void addToWorkflow(Workflow wf)
	{
		if(this.workflow==null)
		{
			workflow=new ArrayList<Workflow>();
		}
		workflow.add(wf);
		session.put("workflowsession", workflow);
		
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
	        for(int i=0;i<workflow.size();i++)
	        	System.out.println("fetched again : "+workflow.get(i).getWfname());
	        return "success";
	} 

}
