package action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberFunctions extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private String submit; 
    private ArrayList<Workflow> workflow = new ArrayList<Workflow>();
    private ArrayList<String> membertype = new ArrayList<String>();
	private ArrayList<Role> rolelist = new ArrayList<Role>();
	private ArrayList<String> rolenames = new ArrayList<String>();
	Map<String, Object> session;
	private Member member;
	private Member member_loggedin;
	private String rolename;
	private int memberid;
	private String fname;
	private String lname;
	private String username;
	private String emailid;
	private BigDecimal phone;
	private String address;
	private int membermanagerid;
	
	
	
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getMember_loggedin() {
		return member_loggedin;
	}

	public void setMember_loggedin(Member member_loggedin) {
		this.member_loggedin = member_loggedin;
	}

	public int getMembermanagerid() {
		return membermanagerid;
	}

	public void setMembermanagerid(int membermanagerid) {
		this.membermanagerid = membermanagerid;
	}

	public String getRet_val() {
		return ret_val;
	}

	public void setRet_val(String ret_val) {
		this.ret_val = ret_val;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public ArrayList<String> getRolenames() {
		return rolenames;
	}

	public void setRolenames(ArrayList<String> rolenames) {
		this.rolenames = rolenames;
	}

	public ArrayList<Role> getRolelist() {
		return rolelist;
	}

	public void setRolelist(ArrayList<Role> rolelist) {
		this.rolelist = rolelist;
	}

		
	public ArrayList<String> getMembertype() {
		return membertype;
	}

	public void setMembertype(ArrayList<String> membertype) {
		this.membertype = membertype;
	}

	public ArrayList<Workflow> getWorkflow() {
		return workflow;
	}

	public void setWorkflow(ArrayList<Workflow> workflow) {
		this.workflow = workflow;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	String ret_val;

	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		if (submit.startsWith("Next")) {
			rolelist = Role.selectall("");
			for(int i=0;i<rolelist.size();i++)
			{
				rolename=rolelist.get(i).getRolename();
				rolenames.add(rolename);
			}
			
			for(int i=0;i<membertype.size();i++)
			{
				for(int j=0;j<rolenames.size();j++)
				{
					if(membertype.get(i).matches(rolenames.get(j)))
					{
						ret_val=rolenames.get(j);
						System.out.println("############"+ret_val);
						
						break;
					}
				}
					
			}
			session = ActionContext.getContext().getSession();
			member_loggedin = (Member)session.get("memberloggedin");
			System.out.println("Got u "+member_loggedin.getUsername());
			
			member = Member.selectOne("where username='"+member_loggedin.getUsername()+"'");

			this.setMemberid(member.getMemberid());
			this.setFname(member.getFname());
			this.setLname(member.getLname());
			this.setUsername(member.getUsername());
			this.setEmailid(member.getEmailid());
			this.setPhone(member.getPhone());
			this.setAddress(member.getAddress());
			System.out.println("jsut doing" +ret_val);
			
			return ret_val;
		
        }

		
			addActionError(getText("Invalid"));
	        return "error";
	        		
	}
        

 
}
