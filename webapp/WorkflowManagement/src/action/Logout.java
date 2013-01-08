package action;

import java.util.*;

import org.apache.catalina.Session;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport {
    
	private static final long serialVersionUID = 1L;		
	
	public String execute() {
		Map<String, Object> session=ActionContext.getContext().getSession();
		if(!session.containsKey("loggedin"))
			{
				addActionError(getText("User not logged in!"));
				return "error";
			}
		
		session.remove("loggedin");
		return "success_logout";
	}
}
