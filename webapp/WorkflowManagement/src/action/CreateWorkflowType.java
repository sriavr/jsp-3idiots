package action;

import java.util.ArrayList;

import models.*;
import utils.*;
import com.opensymphony.xwork2.ActionSupport;

public class CreateWorkflowType extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String wfname;
    private String description; 
    private ArrayList<Workflow> workflow = new ArrayList<Workflow>();
    
	public ArrayList<Workflow> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<Workflow> workflow) {
		this.workflow = workflow;
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
			if(this.wfname.isEmpty())
				return "initial";
			wf.setWfname(wfname);
			wf.setDescription(description);
			wf.insert();
	        workflow=Workflow.selectall("");
	        return "success";
	} 

}
