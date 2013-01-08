package action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateWorkflowCategory  extends ActionSupport{

	
	
	
//	private ArrayList<Integer> workflow_instances = new ArrayList<Integer>();
//	 private ArrayList<String> workflow_names = new ArrayList<String>();
//
//	 private ArrayList <WorkflowType> workflowtypes = new ArrayList<WorkflowType>();
//	 private ArrayList <WorkflowInstance> workflowinstances = new ArrayList<WorkflowInstance>();
//	 
//	 
//	public ArrayList<Integer> getWorkflow_instances() {
//		return workflow_instances;
//	}
//	public void setWorkflow_instances(ArrayList<Integer> workflow_instances) {
//		this.workflow_instances = workflow_instances;
//	}
//	public ArrayList<String> getWorkflow_names() {
//		return workflow_names;
//	}
//	public void setWorkflow_names(ArrayList<String> workflow_names) {
//		this.workflow_names = workflow_names;
//	}
//	
//	private String wfitemname;
//	public String getWfitemname() {
//		return wfitemname;
//	}
//	public void setWfitemname(String wfitemname) {
//		this.wfitemname = wfitemname;
//	}
//	
//	public String getSubmit() {
//		return submit;
//	}
//	public void setSubmit(String submit) {
//		this.submit = submit;
//	}
//	public String getWfitemcategory() {
//		return wfitemcategory;
//	}
//	public void setWfitemcategory(String wfitemcategory) {
//		this.wfitemcategory = wfitemcategory;
//	}
//	public String getWfitemtype() {
//		return wfitemtype;
//	}
//	public void setWfitemtype(String wfitemtype) {
//		this.wfitemtype = wfitemtype;
//	}
//	public int getQuantityavail() {
//		return quantityavail;
//	}
//	public void setQuantityavail(int quantityavail) {
//		this.quantityavail = quantityavail;
//	}
//	private String wfitemcategory;
//	private String submit;
//	private String wfitemtype;
//	private int quantityavail;
//	private int wftypeid;
//	Map<String, Object> session;
//	WorkflowItem wfitem =new WorkflowItem();
//	public int getWftypeid() {
//		return wftypeid;
//	}
//	public void setWftypeid(int wftypeid) {
//		this.wftypeid = wftypeid;
//	}
//	public Map<String, Object> getSession() {
//		return session;
//	}
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//	}
//	public WorkflowItem getWfitem() {
//		return wfitem;
//	}
//	public void setWfitem(WorkflowItem wfitem) {
//		this.wfitem = wfitem;
//	}
//	
//	
//	private ArrayList<WorkflowItem> workflowitemlist;
//	private void addToWorkflowItem(WorkflowItem wfitem)
//	{ 
//		
//    	workflowitemlist = WorkflowItem.selectall("");
//    	for(int i=0;i<workflowitemlist.size();i++)
//    		System.out.println("Item Info "+ workflowitemlist.get(i).getWftypeid()+" "+workflowitemlist.get(i).getWfitemname());
//    	session.put("itemsession", workflowitemlist);
//		
//	}
//	
//	WorkflowDataDef wfdatadef = new WorkflowDataDef();
//	public ArrayList<WorkflowItem> getWorkflowitemlist() {
//		return workflowitemlist;
//	}
//	public void setWorkflowitemlist(ArrayList<WorkflowItem> workflowitemlist) {
//		this.workflowitemlist = workflowitemlist;
//	}
//	public WorkflowDataDef getWfdatadef() {
//		return wfdatadef;
//	}
//	public void setWfdatadef(WorkflowDataDef wfdatadef) {
//		this.wfdatadef = wfdatadef;
//	}
//	public String execute()
//	{
//		
//		if(this.submit.startsWith("Add"))
//		{
//			
//			if(this.wfitemtype.isEmpty() && this.wfitemname.isEmpty() && this.wfitemcategory.isEmpty())
//			{
//				addActionError(getText("Invalid Workflow Name!!"));
//				return "initial";
//			}
//			
//			System.out.println("Execute of add workflow  item action");
//			
//			session = ActionContext.getContext().getSession();
//			if(session.get("itemsession")==null)
//			{
//				session.put("itemsession", new ArrayList<WorkflowItem>());
//			}
//			this.workflowitemlist=(ArrayList<WorkflowItem>)session.get("itemsession");
//			
//			
//			session = ActionContext.getContext().getSession();
//			
//			wfitem.setWftypeid(this.wftypeid);
//			wfitem.setWfitemtype(this.wfitemtype);
//			wfitem.setWfitemcategory(this.wfitemcategory);
//			wfitem.setWfitemname(this.wfitemname);
//			wfitem.setQuantityavail(this.quantityavail);
//			
//			System.out.println("wftypeid"+" "+wftypeid+" "+"wfitemname"+" "+wfitemname+" ");
//			wfitem.insert();
//			System.out.println("successfully inserted");
//			addToWorkflowItem(wfitem);
//			addActionError(getText("Add Item Successful"));
//			this.wfitemname="";
//			this.wfitemcategory="";
//			this.wfitemtype="";
//			
//			this.quantityavail=0;
//			
//			System.out.println("successfully item created");
//			return "success_item";
//		}
//		
//		
//		if(submit.startsWith("View")){
//			workflowitemlist=new ArrayList<WorkflowItem>();
//			workflowitemlist=WorkflowItem.selectall("");
//			/*for(int i=0;i<workflowitemlist.size();i++)
//			{
//				wfitem=workflowitemlist.get(i);
//				
//			}*/
//			return "viewsuccess";
//		}
//
//		if(this.submit.startsWith("Next"))
//		{
//			workflowtypes  = WorkflowType.selectall("");
//			workflowinstances = WorkflowInstance.selectall("where wftypeid="+wftypeid);
//			for(int i=0;i<workflowtypes.size();i++)
//			{
//				workflow_names.add(workflowtypes.get(i).getWfname());
//			}
//			for(int i=0;i<workflowinstances.size();i++)
//			{
//				workflow_instances.add(workflowinstances.get(i).getWfinstanceid());
//			}
//			return "next";
//		}
//		addActionError(getText("Invalid Add Member!"));
//        return "initial";
//	    
//		
//		}
//		
		
		
	}
	
	


