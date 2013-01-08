package action;

import model.WorkflowInstanceDetails;
import model.WorkflowTypeDetails;
import model.Member;

import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport {
	int memberid;
	private String cmd;
	private Member member = new Member();

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	
	public String execute() throws Exception {
		System.out.println("In memberaction : "+memberid);
		member = Member.selectOne(memberid);
		System.out.println("Member info : "+ member.getMemberid()+" "+member.getFname());	
		if (cmd.equals("displaymemberdetails")) {
			if (memberid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaymemberdetails";
		}				return ERROR;
	};
}
