package action;

import java.math.BigDecimal;
import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMember extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	private int memberid;
	private int roleid;
	private String fname;
	private String lname;
	private String emailid;
	private BigDecimal phone;
	private String username;
	private String password;
	private String address;
	
	private ArrayList<Member> memberlist;

	Map<String, Object> session;
	
	private void addToMember(Member member)
	{
		if(this.memberlist==null)
		{
			memberlist=new ArrayList<Member>();
		}
		memberlist.add(member);
		session.put("membersession", memberlist);
		
	}
	
	
	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
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




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public ArrayList<Member> getMemberlist() {
		return memberlist;
	}




	public void setMemberlist(ArrayList<Member> memberlist) {
		this.memberlist = memberlist;
	}




	public String execute() {
        /*MyLog.log("in Login.execute() with submit = " + 
	        this.submit); */
		
			System.out.println("Execute of add member action");
		
			session = ActionContext.getContext().getSession();
			Member member = new Member();
			if(session.get("membersession")==null)
			{
				session.put("membersession", new ArrayList<Member>());
			}
			this.memberlist=(ArrayList<Member>)session.get("membersession");

			if(this.fname.isEmpty() && this.lname.isEmpty())
				return "initial";
			member.setMemberid(memberid);
			member.setRoleid(roleid);
			member.setFname(fname);
			member.setLname(lname);
			member.setEmailid(emailid);
			member.setPhone(phone);
			member.setUsername(username);
			member.setPassword(password);
			member.setAddress(address);
			member.insert();
			addToMember(member);
		    return "success";
	} 

}
