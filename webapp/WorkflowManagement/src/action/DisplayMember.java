package action;
import java.math.BigDecimal;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import models.Member;
import models.Role;

public class DisplayMember {
	
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
	private String radiomemberid;
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setRadiomemberid(String radiomemberid) {
		this.radiomemberid = radiomemberid;
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
	Map<String, Object> session;
	
	
	public  String execute()
	{
		
		
				 
		if(this.submit.startsWith("Delete"))
		{
			
				//member.setRoleid(roleid);
				System.out.println("radiomemberid  -->"+radiomemberid);
				
				member.setMemberid(Integer.parseInt(radiomemberid));
				/*member.setFname(fname);
				member.setLname(lname);
				member.setEmailid(emailid);
				member.setPhone(phone);
				member.setUsername(username);
				member.setPassword(password);
				member.setAddress(address);
				*/
				member.delete();
				
				System.out.println("After delete in member");
				
				memberlist = member.selectall("");
		    	for(int i=0;i<memberlist.size();i++)
		    		System.out.println("Member Info "+ memberlist.get(i).getMemberid());
		    	session.put("membersession", memberlist);
				
//				/addActionMessage(getText("Delete Member Successful"));
		        
					
		
			return "delete_success";
		}
		if(this.submit.startsWith("Display"))
			{
			
			
				System.out.println("radiomemberid "+radiomemberid);
				member=Member.selectOne("where memberid="+radiomemberid);
				System.out.println("member info fetched");
				this.setMemberid(Integer.parseInt(radiomemberid));
				this.setRoleid(member.getRoleid());
				this.setLname(member.getLname());
				this.setFname(member.getFname());
				this.setPassword(member.getPassword());
				this.setUsername(member.getUsername());
				this.setEmailid(member.getEmailid());
				this.setAddress(member.getAddress());
				this.setPhone(member.getPhone());
		
				System.out.println(getMemberid());
				return "display_success";
			}
		
			
		/*if(this.submit.startsWith("Back"))
		return "back";
*/		
	
        	return "null";
	}
}
