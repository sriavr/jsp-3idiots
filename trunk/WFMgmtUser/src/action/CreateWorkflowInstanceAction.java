package action;

import java.util.ArrayList;

import util.DB;

import model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CreateWorkflowInstanceAction extends ActionSupport {
	private int wftypeid;
	private String cmd;
	private int wfinstanceid;
	private int memberid;
	private String submit;
	private int categoryid;
	private ArrayList<WorkflowCategory> categories = new ArrayList<WorkflowCategory>();
	private int actionid;
	private ArrayList<Action> actions = new ArrayList<Action>();
	private WorkflowInstanceDetails wfInstanceDetails = new WorkflowInstanceDetails();
	private Action action;
	private ArrayList<WorkflowDataAll> workflowData = new ArrayList<WorkflowDataAll>();

	public ArrayList<WorkflowDataAll> getWorkflowData() {
		return workflowData;
	}

	public void setWorkflowData(ArrayList<WorkflowDataAll> workflowData) {
		this.workflowData = workflowData;
	}

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

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wftypeid) {
		this.wftypeid = wftypeid;
	}

	public ArrayList<WorkflowCategory> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<WorkflowCategory> categories) {
		this.categories = categories;
	}

	public int getMemberid() {
		return memberid;
	}

	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	/*
	 * public WorkflowInstanceDetails getWfInstanceDetails() { return
	 * wfInstanceDetails; }
	 * 
	 * public void setWfInstanceDetails(WorkflowInstanceDetails
	 * wfInstanceDetails) { this.wfInstanceDetails = wfInstanceDetails; }
	 */
	@Override
	public String execute() throws Exception {
		System.out
				.println("Inside execute method of CreateWorkflowInstanceAction");
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

		if (cmd.trim().equalsIgnoreCase("createworkflowinstance")) {
			// wfinstance.insert();
			// addActionError(getText("Creates workflow instance successfully"));
			System.out.println("Inside createworkflowinstance");
			categories = WorkflowCategory.selectall(wftypeid);
			actions = Action.selectuseractions(roleid);
			workflowData = WorkflowDataAll.selectwftype(wftypeid);
			return "createworkflowinstance";
		}
		if (submit.startsWith("Action")) {
			if (wfinstanceid == 0) {
				addActionError(getText("No instance selected"));
				return ERROR;
			}

			// wfinstance.insert();
			// addActionError(getText("Creates workflow instance successfully"));
			return "actionselected";
		}

		if (submit.startsWith("Submit Workflow")) {
			System.out.println("Inside Submit workflow part");
			System.out.println("CategoryID: " + categoryid + " ActionID: "
					+ actionid);
			System.out.println("workflowData size:" + workflowData.size());
			for (int i = 0; i < workflowData.size(); i++) {
				System.out.println("name:"
						+ workflowData.get(i).getWorkflowDataDef().getName()
						+ "Value:"
						+ workflowData.get(i).getValue()
						+ " constantvalue:"
						+ workflowData.get(i).getWorkflowDataDef()
								.getConstantvalue());
			}

			System.out.println("Before createnewInstance method");
			WorkflowInstanceDetails wfInstance = new WorkflowInstanceDetails();
			wfInstance.getWorkflowInstance().getOwner().setMemberid(memberid);
			wfInstance.getWorkflowType().setWftypeid(wftypeid);
			wfInstance.getWorkflowInstance().getWfcategory()
					.setWfcategoryid(categoryid);
			wfinstanceid = wfInstance.createnewInstance();
			System.out.println("End of createnewinstane wfinstanceid:"
					+ wfinstanceid);
			return "success";
		}
		return ERROR;
	}

	public int getWfinstanceid() {
		return wfinstanceid;
	}

	public void setWfinstanceid(int wfInstanceId) {
		this.wfinstanceid = wfInstanceId;
	}

	public WorkflowInstanceDetails getWfInstanceDetails() {
		return wfInstanceDetails;
	}

	public void setWfInstanceDetails(WorkflowInstanceDetails wfInstanceDetails) {
		this.wfInstanceDetails = wfInstanceDetails;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
}
