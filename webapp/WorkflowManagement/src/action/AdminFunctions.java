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
	        if (submit.startsWith("Add Role")) {
	        	System.out.println("In add role");
			    return "addrole";
	        }
	        
	        if (submit.startsWith("Add Member")) {
	        	System.out.println("In add member");
			    return "addmember";
	        }
	        
	        addActionError(getText("Invalid"));
	        return "error";
	        		
	}
        

 
}
