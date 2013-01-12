package action;

import java.util.ArrayList;

import model.Action;
import model.Admin;
import model.Member;
import model.WorkflowInstanceDetails;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WorkflowInstanceAction extends ActionSupport {

	private String cmd;
	private int wfinstanceid = 0;
	private WorkflowInstanceDetails wfInstanceDetails = new WorkflowInstanceDetails();
	private int actionid;
	private ArrayList<Action> actions = new ArrayList<Action>();

	public int getActionid() {
		return actionid;
	}

	public void setActionid(int actionid) {
		this.actionid = actionid;
	}

	public ArrayList<Action> getActions() {
		return actions;
	}

	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public WorkflowInstanceDetails getWfInstanceDetails() {
		return wfInstanceDetails;
	}

	public void setWfInstanceDetails(WorkflowInstanceDetails wfInstanceDetails) {
		this.wfInstanceDetails = wfInstanceDetails;
	}

	int wftypeid;
	int memberid;

	@Override
	public String execute() throws Exception {
		System.out.println("Inside execute method of WorkflowInstanceAction");
		boolean isAdmin = (Boolean) ActionContext.getContext().getSession()
				.get("isAdmin");
		Member member;
		Admin admin;
		int roleid = 0;
		if (isAdmin) {
			wftypeid = 0;
		} else {
			member = (Member) ActionContext.getContext().getSession()
					.get("memberloggedin");
			wftypeid = member.getRole().getWorkflowType().getWftypeid();
			roleid = member.getRole().getRoleid();
			memberid = member.getMemberid();
		}
		System.out.println("wftype id " + wftypeid + " cmd:" + cmd + " roleid:"
				+ roleid);

		WorkflowInstanceDetails wfInstanceDetails = WorkflowInstanceDetails
				.selectone(wfinstanceid);
		this.setWfInstanceDetails(wfInstanceDetails);
		System.out.println("Instance id: "
				+ wfInstanceDetails.getWorkflowInstance().getWfinstanceid());

		if (cmd.equals("displayinstancedetails")) {
			actions = Action.selectuseractions(roleid);
			ActionContext.getContext().getSession().put("currentinstance", wfinstanceid);
			if (wfinstanceid == 0) {
				addActionError(getText("No instance selected"));
				return ERROR;
			}

			return "displayinstancedetails";
		} else if (cmd.equals("displayeventhistory")) {
			if (wfinstanceid == 0) {
				addActionError(getText("No instance selected"));
				return ERROR;
			}

			return "displayeventhistory";
		} else if (cmd.equals("displayworkflowinstancedata")) {
			if (wfinstanceid == 0) {
				addActionError(getText("No instance selected"));
				return ERROR;
			}

			return "displayworkflowinstancedata";
		}

		return ERROR;
	}

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfInstanceId) {
		this.wfinstanceid = wfInstanceId;
	}
}
