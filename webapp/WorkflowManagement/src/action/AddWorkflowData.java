package action;

import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddWorkflowData extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int wfdatadefid;
	private int wfdataid;
	private int wftypeid;
	private int wfinstanceid;
	private String name;
	private String value;
    private String description; 
    private int isreadonly;
    private String submit;
    
   
    private ArrayList<WorkflowDataAll> workflowdataall;
    private ArrayList<WorkflowData> workflowdata = new ArrayList<WorkflowData>();
    private ArrayList<WorkflowDataDef> workflowdatadef = new ArrayList<WorkflowDataDef>();
    
    private ArrayList<WorkflowData> viewworkflowdata = new ArrayList<WorkflowData>();
    private ArrayList<WorkflowDataDef> viewworkflowdatadef = new ArrayList<WorkflowDataDef>();
    
    WorkflowDataDef wfdatadef = new WorkflowDataDef();
    WorkflowData wfdata = new WorkflowData();
    
    Map<String,Object> session;
    
    private void addToWorkflowData(WorkflowData wfdata)
	{ 
		
    	workflowdata = WorkflowData.selectall("");
    	for(int i=0;i<workflowdata.size();i++)
    		System.out.println("workflowdata Info "+ workflowdata.get(i).getWfdatadefid()+" "+workflowdata.get(i).getWfdataid()+" "+workflowdata.get(i).getWfinstanceid()+" "+workflowdata.get(i).getValue());
    	session.put("workflowdatasession", workflowdata);
		
	}
    
    private void addToWorkflowDataDef(WorkflowDataDef wfdatadef)
  	{ 
  		
      	workflowdatadef = WorkflowDataDef.selectalldef("");
      	for(int i=0;i<workflowdatadef.size();i++)
      		System.out.println("workflowdatadef Info "+ workflowdatadef.get(i).getWfdatadefid()+" "+workflowdatadef.get(i).getWftypeid()+" "+workflowdatadef.get(i).getName());
      	session.put("workflowdatadefsession", workflowdatadef);
  		
  	}
    
    public String execute() {
    	if(submit.startsWith("Add"))
		{
			WorkflowData wfdata = new WorkflowData();
			WorkflowDataDef wfdatadef = new WorkflowDataDef();
			session = ActionContext.getContext().getSession();
			if(session.get("workflowdatasession")==null)
			{
				session.put("workflowdatasession", new ArrayList<WorkflowData>());
			}
			if(session.get("workflowdatadefsession")==null)
			{
				session.put("workflowdatadefsession", new ArrayList<WorkflowDataDef>());
			}
			
			this.workflowdata=(ArrayList<WorkflowData>)session.get("workflowdatasession");
			this.workflowdatadef = (ArrayList<WorkflowDataDef>)session.get("workflowdatadefsession");
		
			if(this.name.isEmpty())
				return "initial";
			
			wfdatadef.setWfdatadefid(wfdatadefid);
			wfdatadef.setWftypeid(wftypeid);
			wfdatadef.setName(name);	
			wfdatadef.setDescription(description);
			wfdatadef.setIsreadonly(isreadonly);
			
			wfdata.setWfdatadefid(wfdatadefid);
			wfdata.setWfdataid(wfdataid);
			wfdata.setWfinstanceid(wfinstanceid);
			wfdata.setValue(value);
			
			wfdatadef.insertdef();
			wfdata.insert();
			
			System.out.println("After insert in workflow data and workflow datadef");
			addToWorkflowData(wfdata);
			addToWorkflowDataDef(wfdatadef);
			
	        addActionError(getText("Created Workflow Data Successfully"));
	        return "addsuccess";
		}   
    	if(submit.startsWith("View")){
			workflowdata=new ArrayList<WorkflowData>();
			workflowdata=WorkflowData.selectall("");
			
			workflowdatadef=new ArrayList<WorkflowDataDef>();
			workflowdatadef=WorkflowDataDef.selectalldef("");
			
			for(int i=0;i<workflowdatadef.size();i++)
			{
				wfdatadef=workflowdatadef.get(i);
				viewworkflowdatadef.add(wfdatadef);
				System.out.println("Name " + viewworkflowdatadef.get(i).getName());
			}
			
			for(int i=0;i<workflowdata.size();i++)
			{
				wfdata=workflowdata.get(i);
				viewworkflowdata.add(wfdata);
				System.out.println("Value " +viewworkflowdata.get(i).getValue());
			}
			return "viewsuccess";
		}
	        
				
	    addActionError(getText("Invalid  Create Workflow Data!"));
	    return "error";
	}


	public int getWfdatadefid() {
		return wfdatadefid;
	}


	public void setWfdatadefid(int wfdatadefid) {
		this.wfdatadefid = wfdatadefid;
	}


	public int getWfdataid() {
		return wfdataid;
	}


	public void setWfdataid(int wfdataid) {
		this.wfdataid = wfdataid;
	}


	public int getWftypeid() {
		return wftypeid;
	}


	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}


	public int getWfinstanceid() {
		return wfinstanceid;
	}


	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getIsreadonly() {
		return isreadonly;
	}


	public void setIsreadonly(int isreadonly) {
		this.isreadonly = isreadonly;
	}


	public String getSubmit() {
		return submit;
	}


	public void setSubmit(String submit) {
		this.submit = submit;
	}


	public ArrayList<WorkflowDataAll> getWorkflowdataall() {
		return workflowdataall;
	}


	public void setWorkflowdataall(ArrayList<WorkflowDataAll> workflowdataall) {
		this.workflowdataall = workflowdataall;
	}


	public ArrayList<WorkflowData> getWorkflowdata() {
		return workflowdata;
	}


	public void setWorkflowdata(ArrayList<WorkflowData> workflowdata) {
		this.workflowdata = workflowdata;
	}


	public ArrayList<WorkflowDataDef> getWorkflowdatadef() {
		return workflowdatadef;
	}


	public void setWorkflowdatadef(ArrayList<WorkflowDataDef> workflowdatadef) {
		this.workflowdatadef = workflowdatadef;
	}


	public WorkflowDataDef getWfdatadef() {
		return wfdatadef;
	}


	public void setWfdatadef(WorkflowDataDef wfdatadef) {
		this.wfdatadef = wfdatadef;
	}


	public WorkflowData getWfdata() {
		return wfdata;
	}


	public void setWfdata(WorkflowData wfdata) {
		this.wfdata = wfdata;
	}


}
