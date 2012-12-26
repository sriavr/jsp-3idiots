package action;
import java.math.BigDecimal;
import java.util.*;

//import com.opensymphony.xwork2.ActionContext;

import models.Member;
import models.Role;

public class ModifyMember {
	
	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private int memberid;
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

	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	private String MemberName;

	Member member =new Member();
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public ArrayList<Member> getMemberlist() {
		return memberlist;
	}
	public void setMemberlist(ArrayList<Member> memberlist) {
		this.memberlist = memberlist;
	}
	ArrayList<Member> memberlist =new ArrayList<Member>();
	
	
	public  String execute()
	{
		
		if(this.submit.startsWith("Delete"))
		{
			
				member.setRoleid(roleid);
				member.setMemberid(memberid);
				member.setFname(fname);
				member.setLname(lname);
				member.setEmailid(emailid);
				member.setPhone(phone);
				member.setUsername(username);
				member.setPassword(password);
				member.setAddress(address);
				System.out.println("roleid"+" "+roleid+" "+"memberid"+" "+memberid);
		
				member.delete();
				
				System.out.println("After delete in member");
				
				memberlist = member.selectall("");
		    	for(int i=0;i<memberlist.size();i++)
		    		System.out.println("Member Info "+ memberlist.get(i).getMemberid());
		    	//session.put("membersession", memberlist);
				
				//addActionMessage(getText("Delete Member Successful"));
		        
					
		
			return "delete_success";
		}
			
        if(this.submit.startsWith("Modify")){
		
		member.setRoleid(roleid);
		member.setMemberid(memberid);
		member.setFname(fname);
		member.setLname(lname);
		member.setEmailid(emailid);
		member.setPhone(phone);
		member.setUsername(username);
		member.setPassword(password);
		member.setAddress(address);
		
		System.out.println("member values : "+member.getMemberid());
		member.update();
		System.out.println(member.getRoleid()+" "+member.getFname());
		System.out.println("Modified member successfully");
		//addActionMessage(getText("Modify Member Successful"));
		return "modify_success";
		}

        //addActionError(getText("Invalid Modify Role!"));
        return "error";

	}
	
}
