package ITAssetAllocation;

import models.*;
import action.*;
import java.math.BigDecimal;
import java.util.*;

import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReportingManager extends ActionSupport{

	public int getMemberid() {
		return memberid;
	}


	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}


	public int getMembermanagerid() {
		return membermanagerid;
	}


	public void setMembermanagerid(int membermanagerid) {
		this.membermanagerid = membermanagerid;
	}


	public int getRoleid() {
		return roleid;
	}


	public void setRoleid(int roleid) {
		this.roleid = roleid;
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


	public int getWftypeid() {
		return wftypeid;
	}


	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public int getActionid() {
		return actionid;
	}


	public void setActionid(int actionid) {
		this.actionid = actionid;
	}


	public String getActionname() {
		return actionname;
	}


	public void setActionname(String actionname) {
		this.actionname = actionname;
	}


	public int getStateid() {
		return stateid;
	}


	public void setStateid(int stateid) {
		this.stateid = stateid;
	}


	public String getStatename() {
		return statename;
	}


	public void setStatename(String statename) {
		this.statename = statename;
	}


	


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	
	private int memberid;
	private int membermanagerid;
	private int roleid;
	private String fname;
	private String lname;
	private String username;
	private String emailid;
	private BigDecimal phone;
	private String address;
	private String submit;
	private int wftypeid;
	private String rolename;
	private int actionid;
	private String  actionname;
	private int stateid;
	private String statename;
	ReportingManager rmember=new ReportingManager();
	
	Map<String, Object> session;
	private ArrayList<models.ReportingManager> rminstance  = new ArrayList<models.ReportingManager>();

	
	/*private ArrayList<String> assetcategory = new ArrayList<String>();
	private ArrayList<String> assetname = new ArrayList<String>();
	*/
	
	
	public ArrayList<models.ReportingManager> getRminstance() {
		return rminstance;
	}


	public void setRminstance(ArrayList<models.ReportingManager> rminstance) {
		this.rminstance = rminstance;
	}


	public Member getMember() {
		return member;
	}



	Member member=new Member();
	public ReportingManager getRmember() {
		return rmember;
	}


	public void setRmember(ReportingManager rmember) {
		this.rmember = rmember;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public StateSequence getState() {
		return state;
	}


	public void setState(StateSequence state) {
		this.state = state;
	}


	public Actions getAction() {
		return action;
	}


	public void setAction(Actions action) {
		this.action = action;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	Role role =new Role();
	StateSequence state = new StateSequence();
	Actions action =new Actions();
	
	


	public String execute()
	{
		System.out.println("Execute of ReportingManager Page");
		session = ActionContext.getContext().getSession();
		
		
		System.out.println("member id : "+memberid);
		System.out.println("Member id : "+member.getMemberid());
		
		
				
		
		if(submit.startsWith("View"))
		{
			rminstance = models.ReportingManager.selectOne("where membermanagerid="+memberid+" , roleid="+roleid);
						
			for(int i=0;i<rminstance.size();i++)
			{
				fname = rminstance.get(i).getFname();
				System.out.println("fname = "+fname);
			}
			
			return "view_success";
		}
		
		addActionError(getText("Invalid  Employee Action!"));
	    return "error";
} 

}
	
	

