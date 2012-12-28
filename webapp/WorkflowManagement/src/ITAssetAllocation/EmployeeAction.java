package ITAssetAllocation;

import models.*;
import action.*;
import java.math.BigDecimal;
import java.util.*;

import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport{

	private int memberid;
	private String fname;
	private String lname;
	private String username;
	private String emailid;
	private BigDecimal phone;
	private String address;
	private String submit;
	private int wfitemid;
	Member member=new Member();
	Member member_loggedin = new Member();
	Map<String, Object> session;
	private ArrayList<WorkflowInstance> wfinstance  = new ArrayList<WorkflowInstance>();
	private Set<String> assetcategory = new HashSet<String>();
	private Set<String> assetname = new HashSet<String>();
	
	/*private ArrayList<String> assetcategory = new ArrayList<String>();
	private ArrayList<String> assetname = new ArrayList<String>();
	*/
	ArrayList<WorkflowItem> workflowitems = new ArrayList<WorkflowItem>();
	WorkflowItem workflowitem = new WorkflowItem();
	
	
	public int getMemberid() {
		return memberid;
	}





	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}





	public String getFname() {
		return fname;
	}





	public void setFname(String fname) {
		this.fname = fname;
	}





	public String getLname() {
		return lname;
	}





	public void setLname(String lname) {
		this.lname = lname;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getEmailid() {
		return emailid;
	}





	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}





	public BigDecimal getPhone() {
		return phone;
	}





	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public String getSubmit() {
		return submit;
	}





	public void setSubmit(String submit) {
		this.submit = submit;
	}





	public int getWfitemid() {
		return wfitemid;
	}





	public void setWfitemid(int wfitemid) {
		this.wfitemid = wfitemid;
	}





	public Member getMember() {
		return member;
	}





	public void setMember(Member member) {
		this.member = member;
	}





	public ArrayList<WorkflowInstance> getWfinstance() {
		return wfinstance;
	}





	public void setWfinstance(ArrayList<WorkflowInstance> wfinstance) {
		this.wfinstance = wfinstance;
	}





	

	public ArrayList<WorkflowItem> getWorkflowitems() {
		return workflowitems;
	}





	public void setWorkflowitems(ArrayList<WorkflowItem> workflowitems) {
		this.workflowitems = workflowitems;
	}





	public WorkflowItem getWorkflowitem() {
		return workflowitem;
	}


	


	public Member getMember_loggedin() {
		return member_loggedin;
	}





	public void setMember_loggedin(Member member_loggedin) {
		this.member_loggedin = member_loggedin;
	}


		public Set<String> getAssetcategory() {
		return assetcategory;
	}





	public void setAssetcategory(Set<String> assetcategory) {
		this.assetcategory = assetcategory;
	}





	public Set<String> getAssetname() {
		return assetname;
	}





	public void setAssetname(Set<String> assetname) {
		this.assetname = assetname;
	}



			public void setWorkflowitem(WorkflowItem workflowitem) {
		this.workflowitem = workflowitem;
	}



	public String execute()
	{
		System.out.println("Execute of Employee Page");
		session = ActionContext.getContext().getSession();
		member_loggedin = (Member)session.get("memberloggedin");
		memberid = member_loggedin.getMemberid();
		System.out.println("member id : "+memberid);
		member = Member.selectOne("where memberid="+memberid);
		System.out.println("Member id : "+member.getMemberid());
		this.setMemberid(member.getMemberid());
		this.setFname(member.getFname());
		this.setLname(member.getLname());
		this.setUsername(member.getUsername());
		this.setEmailid(member.getEmailid());
		this.setPhone(member.getPhone());
		this.setAddress(member.getAddress());
		
		if(submit.startsWith("New"))
		{
			workflowitems = WorkflowItem.selectall("where wfitemtype='Asset'");
			for(int i=0;i<workflowitems.size();i++)
			{
				//System.out.println("category = "+workflowitems.get(i).getWfitemcategory());
				assetcategory.add(workflowitems.get(i).getWfitemcategory());
				assetname.add(workflowitems.get(i).getWfitemname());
			}
			
			System.out.println("Assetcategory :");
			
			Iterator<String> itr1 = assetcategory.iterator();
			while(itr1.hasNext())
			{
				System.out.println(itr1.next()+" ");
			}
		
			System.out.println("Assetname :");
			
			Iterator<String> itr2 = assetname.iterator();
			while(itr2.hasNext())
			{
				System.out.println(itr2.next()+" ");
			}
		
			return "itassetrequest";
		}
		
		if(submit.startsWith("View"))
		{
			wfinstance= WorkflowInstance.selectall("where memberid="+memberid);			
			for(int i=0;i<wfinstance.size();i++)
			{
				wfitemid = wfinstance.get(i).getWfitemid();
				workflowitem = WorkflowItem.selectOne("where wfitemid="+wfitemid);
				workflowitems.add(workflowitem);
			}
			
			return "allocatedassets";
		}
		
		addActionError(getText("Invalid  Employee Action!"));
	    return "error";
} 

}
	
	

