package ITAssetAllocation;

import models.*;
import action.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import utils.*;
import SendMail.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AssetAllotment extends ActionSupport{

	private int wfinstanceid;
	private int wfitemid;
	private int wftypeid;
	private String wfitemtype;
	private String wfitemcategory;
	private String wfitemname;
	private int quantityavail;
	private String submit;
	
	private String asset_name;
	private String asset_category;
	
	private WorkflowItem workflowitem = new WorkflowItem();
	private Actions action = new Actions();
    private StateSequence stateseq = new StateSequence();
	
	Map<String, Object> session;
	private Member member_loggedin = new Member();
	private int memberid;
	private String creationdatetime;
	private int currentstate;
	
	public String execute()
	{
		System.out.println("Execute of Asset Allotment");
		
		if(submit.startsWith("Submit"))
		{
			System.out.println("In submit req");
			/** Request submitted and mail to be sent to manager.
			 *  
			 *  If Manager approves, IT team sends mail to employee whether the request is in-progress 
			 *  or whether there is one more level of approval needed (based on employee designation).
			 *  
			 *  If manager doesnot approve, request is closed.
			 *  
			 *  If quantity is available, asset is allocated.
			 *  
			 *  If quantity is unavailable, asset request is forwarded to purchase dept.
			 * 
			 * **/
			
			WorkflowInstance workflowinstance = new WorkflowInstance();
			workflowitem = WorkflowItem.selectOne("where wfitemcategory='"+getAsset_category()+"' and wfitemname='"+getAsset_name()+"'");
			
			
			/** create new workflow instance entry**/
			
			session = ActionContext.getContext().getSession();
			member_loggedin = (Member)session.get("memberloggedin");
			memberid = member_loggedin.getMemberid();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			creationdatetime = dateFormat.format(date);
		
			System.out.println("wfitemid : "+workflowitem.getWfitemid());
			System.out.println("wftypeid : "+workflowitem.getWftypeid());
			wfitemid=workflowitem.getWfitemid();
			wftypeid=workflowitem.getWftypeid();
			
			action=Actions.selectOne("where actionname='apply' and wftypeid="+wftypeid);
			int actionid = action.getActionid();
			stateseq = StateSequence.selectOne("where actionid="+actionid);
			currentstate = stateseq.getPreviousstateid();

			workflowinstance.setWfinstanceid(wfinstanceid);
			workflowinstance.setWfitemid(wfitemid);
			workflowinstance.setWftypeid(wftypeid);
			workflowinstance.setMemberid(memberid);
			workflowinstance.setCreationdatetime(creationdatetime);
			workflowinstance.setCurrentstate(currentstate);
			
			workflowinstance.insert();
			
			System.out.println("Inserted the new IT asset request into wf instance");
			
			/** Mail module **/
		
			
			/** Mail module **/
			addActionError(getText("Asset Request submitted successfully!"));
			return "success";
		}
		
		
		addActionError(getText("Invalid  Asset Allotment Action!"));
	    return "error";
}

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfinstanceid) {
		this.wfinstanceid = wfinstanceid;
	}

	public int getWfitemid() {
		return wfitemid;
	}

	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public String getWfitemtype() {
		return wfitemtype;
	}

	public void setWfitemtype(String wfitemtype) {
		this.wfitemtype = wfitemtype;
	}

	public String getWfitemcategory() {
		return wfitemcategory;
	}

	public void setWfitemcategory(String wfitemcategory) {
		this.wfitemcategory = wfitemcategory;
	}

	public String getWfitemname() {
		return wfitemname;
	}

	public void setWfitemname(String wfitemname) {
		this.wfitemname = wfitemname;
	}

	public int getQuantityavail() {
		return quantityavail;
	}

	public void setQuantityavail(int quantityavail) {
		this.quantityavail = quantityavail;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}
    
	
	public String getAsset_name() {
		return asset_name;
	}

	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}

	public String getAsset_category() {
		return asset_category;
	}

	public void setAsset_category(String asset_category) {
		this.asset_category = asset_category;
	}

	public WorkflowItem getWorkflowitem() {
		return workflowitem;
	}

	public void setWorkflowitem(WorkflowItem workflowitem) {
		this.workflowitem = workflowitem;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

	public StateSequence getStateseq() {
		return stateseq;
	}

	public void setStateseq(StateSequence stateseq) {
		this.stateseq = stateseq;
	}

	public Member getMember_loggedin() {
		return member_loggedin;
	}

	public void setMember_loggedin(Member member_loggedin) {
		this.member_loggedin = member_loggedin;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getCreationdatetime() {
		return creationdatetime;
	}

	public void setCreationdatetime(String creationdatetime) {
		this.creationdatetime = creationdatetime;
	}

	public int getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(int currentstate) {
		this.currentstate = currentstate;
	}

	
}
	
	

