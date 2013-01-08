package action;

import java.util.ArrayList;
import java.util.Map;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminFunctions extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String submit; 
    private ArrayList<WorkflowType> workflow = new ArrayList<WorkflowType>();   
	
    
	public ArrayList<WorkflowType> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<WorkflowType> workflow) {
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
			if (submit.startsWith("Next")) {
				System.out.println("Admin Page");
			    return "next";
	        }

	   

			if (submit.startsWith("View")) {
				System.out.println("In view workflow");
				workflow = WorkflowType.selectall("");
			    return "viewworkflow";
	        }

			
			if(submit.startsWith("Display"))
			{
				return "display";
			}
			
			if(submit.startsWith("Delete"))
			{
				
			}
			addActionError(getText("Invalid"));
	        return "error";
	        		
	}
        

 
}
