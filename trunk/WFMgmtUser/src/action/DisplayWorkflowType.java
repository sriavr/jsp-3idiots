package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DisplayWorkflowType extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String radiowftypeid;
	private int wftypeid;
	private String wfname;
    private String description; 
    private String submit;
    private ArrayList<WorkflowType> workflow;
    WorkflowType wf=new WorkflowType();

    Map<String, Object> session;

    
    
	public String getRadiowftypeid() {
		return radiowftypeid;
	}



	public void setRadiowftypeid(String radiowftypeid) {
		this.radiowftypeid = radiowftypeid;
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



	public String getSubmit() {
		return submit;
	}



	public void setSubmit(String submit) {
		this.submit = submit;
	}



	public ArrayList<WorkflowType> getWorkflow() {
		return workflow;
	}



	public void setWorkflow(ArrayList<WorkflowType> workflow) {
		this.workflow = workflow;
	}



	public WorkflowType getWf() {
		return wf;
	}



	public void setWf(WorkflowType wf) {
		this.wf = wf;
	}



	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
		if(submit.startsWith("Display")){
		System.out.println("radiowftypeid "+radiowftypeid);
		wf=WorkflowType.selectOne("where wftypeid="+radiowftypeid);
		System.out.println("wf info fetched");
		this.setWftypeid(Integer.parseInt(radiowftypeid));
		this.setWfname(wf.getWfname());
		this.setDescription(wf.getDescription());
		System.out.println(getWftypeid()+" "+getWfname()+" "+getDescription());
		return "displaysuccess";
		}

		if(submit.startsWith("Back"))
		{
			return "back";
		}
			
		addActionError(getText("Invalid Display Role!"));
        return "error";
	} 

}
