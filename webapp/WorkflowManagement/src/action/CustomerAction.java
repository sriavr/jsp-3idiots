package action;
import models.*;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CustomerAction extends ActionSupport {
	
	
	private String memberid;
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
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
	private String fname;
	private String lname;
	private String username;
	private String emailid;
	private BigDecimal phone;
	private String address;
	private String submit;
	private ArrayList<Member> memberlist = new ArrayList<Member>();
	Member member =new Member();
	public ArrayList getMemberlist() {
		return memberlist;
	}
	public void setMemberlist(ArrayList memberlist) {
		this.memberlist = memberlist;
	}
	public String execute()
	{
		
		memberlist =Member.selectall("");
		if(this.submit.equals("Apply"))
		{
			for(int i=0;i<memberlist.size();i++)
			{
				if(this.emailid.equals(memberlist.get(i).getEmailid()))
				{
					return "member_verified";
				}
				
			}
			
		}
		
		
		addActionError(getText("Member not valid"));
        return "error";
        		
	}
	}


