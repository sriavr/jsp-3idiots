package action;

import java.util.ArrayList;
import java.util.Map;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminFunctions extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String submit; 
    private ArrayList<Workflow> workflow = new ArrayList<Workflow>();   
	
    
	public ArrayList<Workflow> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<Workflow> workflow) {
		this.workflow = workflow;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}



	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
			if (submit.startsWith("Create Workflow")) {
				System.out.println("In create workflow");
			    return "createworkflow";
	        }
	    /*    if (submit.startsWith("View")) {
	        	System.out.println("In add role");
			    return "addrole";
	        }
	    */    
	        /*if (submit.startsWith("Add Member")) {
	        	System.out.println("In add member");
			    return "addmember";
	        }
	        */

			if (submit.startsWith("View")) {
				System.out.println("In view workflow");
				workflow = Workflow.selectall("");
			    return "viewworkflow";
	        }
			addActionError(getText("Invalid"));
	        return "error";
	        		
	}
        

 
}
