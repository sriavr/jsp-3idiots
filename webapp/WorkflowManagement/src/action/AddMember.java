package action;

import java.math.BigDecimal;
import java.util.*;

import models.*;
import utils.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMember extends ActionSupport {
    
	private static final long serialVersionUID = 1L;
		
	
	private int roleid;
	private String fname;
	private String lname;
	private String emailid;
	private BigDecimal phone;
	private String username;
	private String password;
	private String address;
	private String submit;
	
	public String getSubmit() {
		return submit;
	}




	public void setSubmit(String submit) {
		this.submit = submit;
	}




	public Map<String, Object> getSession() {
		return session;
	}




	public void setSession(Map<String, Object> session) {
		this.session = session;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private ArrayList<Member> memberlist;
	
	Member member =new Member();

	Map<String, Object> session;
	
	private void addToMember(Member member)
	{
/*		if(this.memberlist==null)
		{
			memberlist=new ArrayList<Member>();
		}
		memberlist.add(member);*/
		memberlist = Member.selectall("");
		for(int i=0;i<memberlist.size();i++)
			System.out.println(memberlist.get(i).getRoleid()+"  "+memberlist.get(i).getFname());
		
		session.put("membersession", memberlist);
		
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
		
			memberlist=new ArrayList<Member>();
			if(this.submit.startsWith("Next"))
				return "next";
			if(this.submit.startsWith("View"))
			{
				
				memberlist=member.selectall("");
				
				for(int i=0;i<memberlist.size();i++)
					System.out.println(memberlist.get(i).getFname());
					
				return "display";
			}
			if(this.submit.startsWith("Add"))
			{
				
				if(this.fname.isEmpty() && this.lname.isEmpty())
				{
					addActionError(getText("Invalid Member Name!!"));
					return "initial";
				}
				
				System.out.println("Execute of add member action");
				
				session = ActionContext.getContext().getSession();
				
				if(session.get("membersession")==null)
				{
					session.put("membersession", new ArrayList<Member>());
				}
				this.memberlist=(ArrayList<Member>)session.get("membersession");

				member.setRoleid(roleid);
				member.setFname(fname);
				member.setLname(lname);
				member.setEmailid(emailid);
				member.setPhone(phone);
				member.setUsername(username);
				member.setPassword(password);
				member.setAddress(address);
				System.out.println("roleid"+" "+roleid+" "+"fname"+" "+fname+" "+" "+"lname"+" "+lname);
				member.insert();
				System.out.println("successfully inserted");
				addToMember(member);
				addActionError(getText("Add Member Successful"));
				this.fname="";
				this.lname="";
				this.emailid="";
				//(bigDecimal.intValue)this.phone=0;
				this.username="";
				this.password="";
				this.address="";
				System.out.println("successfully member created");
				return "success";
			}
			addActionError(getText("Invalid Add Member!"));
	        return "initial";
		    
	} 

}
