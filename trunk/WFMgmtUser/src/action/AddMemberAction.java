package action;

import java.math.BigDecimal;
import java.util.*;

import model.*;
import util.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddMemberAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private WorkflowType wfType = new WorkflowType();
	private Member member = new Member();
	private int roleid;
	private String role;
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<Role> roles = new ArrayList<Role>();

	public WorkflowType getWfType() {
		return wfType;
	}

	public void setWfType(WorkflowType wfType) {
		this.wfType = wfType;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

	/*
	 * private int roleid; private String fname; private String lname; private
	 * String emailid; private BigDecimal phone; private String username;
	 * private String password; private String address;
	 */
	/*
	 * private void addToMember(Member member) {
	 * 
	 * if(this.memberlist==null) { memberlist=new ArrayList<Member>(); }
	 * memberlist.add(member);
	 * 
	 * memberlist = Member.selectallwftype(wftype); for (int i = 0; i <
	 * memberlist.size(); i++)
	 * System.out.println(memberlist.get(i).getRole().getRoleid() + "  " +
	 * memberlist.get(i).getFname());
	 * 
	 * session.put("membersession", memberlist);
	 * 
	 * }
	 */

	public String execute() {
		System.out.println("Inside AddMemberAction");
		System.out.println("Before insertion into db");
		System.out.println("MemberName: " + member.getFname() + " "
				+ member.getLname());
		System.out.println("roleid" + roleid + " member.role.roleid:"
				+ member.getRole().getRoleid() + " role:" + role
				+ " member.role.rolename:" + member.getRole().getRolename()
				+ " wftypeid" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		if (wfType != null && wfType.getWftypeid() != 0) {

			if (member.getFname() != null && !member.getFname().equals("")
					&& member.getRole().getRoleid() != 0) {
				member.insert();
			} else {
				addActionError("Enter required details");
			}
			roles = Role.selectallwftypeid(wfType.getWftypeid());
			members = Member.selectallwftype(wfType.getWftypeid());
		} else {
			addActionError("Error occurred wftypeid 0 or wftypeid null");
		}

		System.out.println("After insertion into db");
		System.out.println("MemberName: " + member.getFname());
		System.out.println("roleid" + roleid + " member.role.roleid:"
				+ member.getRole().getRoleid() + " role:" + role
				+ " member.role.rolename:" + member.getRole().getRolename()
				+ " wftypeid" + wfType.getWftypeid() + "WorkflowName: "
				+ wfType.getWfname() + "WorkflowDescription: "
				+ wfType.getDescription());
		wfType = (WorkflowType) ActionContext.getContext().getSession()
				.get("currwftype");
		member.clear();
		return SUCCESS;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
