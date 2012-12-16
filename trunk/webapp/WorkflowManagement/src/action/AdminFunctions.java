package action;

import java.util.ArrayList;

import models.*;
import utils.*;
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
			if (submit.startsWith("Create")) {
				System.out.println("In create workflow");
			    return "createworkflow";
	        }
	        if (submit.startsWith("Add")) {
	        	System.out.println("In add role");
			    return "addrole";
	        }
	      
	        addActionError(getText("Invalid"));
	        return "error";
	        		
	}
        

 
}
