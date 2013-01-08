package action;

import model.WorkflowInstanceDetails;

import com.opensymphony.xwork2.ActionSupport;

public class WorkflowInstanceAction extends ActionSupport {

	private String cmd;
	private int wfinstanceid = 0;
	private WorkflowInstanceDetails wfInstanceDetails = new WorkflowInstanceDetails();

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

	@Override
	public String execute() throws Exception {
		WorkflowInstanceDetails wfInstanceDetails = WorkflowInstanceDetails
				.selectone(wfinstanceid);
		this.setWfInstanceDetails(wfInstanceDetails);
		System.out.println("Instance id: "
				+ wfInstanceDetails.getWorkflowInstance().getWfinstanceid());

		if (cmd.equals("displayinstancedetails")) {
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
