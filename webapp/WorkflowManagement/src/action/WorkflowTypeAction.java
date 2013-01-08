package action;

import model.WorkflowInstanceDetails;
import model.WorkflowTypeDetails;
import model.Member;

import com.opensymphony.xwork2.ActionSupport;

public class WorkflowTypeAction extends ActionSupport {
	private int wftypeid;
	private String cmd;
	private WorkflowTypeDetails wfTypeDetails = new WorkflowTypeDetails();

	public int getWftypeid() {
		return wftypeid;
	}

	public void setWftypeid(int wfTypeId) {
		this.wftypeid = wfTypeId;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public WorkflowTypeDetails getWfTypeDetails() {
		return wfTypeDetails;
	}

	public void setWfTypeDetails(WorkflowTypeDetails wfTypeDetails) {
		this.wfTypeDetails = wfTypeDetails;
	}

	public String execute() throws Exception {
		System.out.println("wftype id " + wftypeid);
		WorkflowTypeDetails wfTypeDetails = WorkflowTypeDetails
				.selectone(wftypeid);
		this.setWfTypeDetails(wfTypeDetails);
		System.out.println("Wftypedetails" + wfTypeDetails.getWorkflowType().getWfname());
		if (cmd.equals("displaytypedetails")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaytypedetails";
		}

		else if (cmd.equals("displayinstances")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displayinstances";
		}
		
		else if (cmd.equals("displaymembers")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displaymembers";
		}
		
		else if (cmd.equals("displayroles")) {
			if (wftypeid == 0) {
				addActionError(getText("No workflow type selected"));
				return ERROR;
			}
			return "displayroles";
		}
		
		return ERROR;
	};
}
